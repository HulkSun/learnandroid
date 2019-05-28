package com.hulk.songzinese

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class AnimalActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var audioManger: AudioManager? = null
    private var onAudioFocusChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
        if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
            || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK
        ) {
            mediaPlayer?.pause()
            mediaPlayer?.seekTo(0)
        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
            mediaPlayer?.start()
        } else
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)
        audioManger = getSystemService(Context.AUDIO_SERVICE) as AudioManager?
        val wordList = ArrayList<Word>()
        wordList.add(Word("鸡", "鸡",R.drawable.chicken_1f414))
        wordList.add(Word("鸭", "鸭",R.drawable.duck_1f986))
        wordList.add(Word("牛", "牛",R.drawable.cow_1f404))
        wordList.add(Word("马", "马",R.drawable.horse_1f40e))
        wordList.add(Word("猪", "猪",R.drawable.pig_1f416))
        wordList.add(Word("狗", "狗",R.drawable.dog_1f415))
        wordList.add(Word("猫", "猫",R.drawable.cat_1f408))
        wordList.add(Word("狮子", "狮子",R.drawable.lion_1f981))
        wordList.add(Word("老虎", "老虎",R.drawable.tiger_1f405))
        wordList.add(Word("猴子", "猴子",R.drawable.monkey_1f412))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter
        listView.setBackgroundColor(resources.getColor(R.color.colorAnimal))
        listView.setOnItemClickListener { _, _, position, _ ->
            releaseMediaPlayer()
            val re = audioManger?.requestAudioFocus(
                onAudioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT
            )
            if (re == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mediaPlayer = MediaPlayer.create(this, wordList[position].getRadioResourceId())
                mediaPlayer?.start()
                mediaPlayer?.setOnCompletionListener {
                    releaseMediaPlayer()
                }
            }
        }
    }

    private fun releaseMediaPlayer() {
        if (this.mediaPlayer != null) {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
        audioManger?.abandonAudioFocus(onAudioFocusChangeListener)
    }
}

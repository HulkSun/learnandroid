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
        wordList.add(Word("鸡", "鸡"))
        wordList.add(Word("鸭", "鸭"))
        wordList.add(Word("鹅", "鹅"))
        wordList.add(Word("牛", "牛"))
        wordList.add(Word("马", "马"))
        wordList.add(Word("猪", "猪"))
        wordList.add(Word("狗", "狗"))
        wordList.add(Word("猫", "猫"))
        wordList.add(Word("狮子", "狮子"))
        wordList.add(Word("老虎", "老虎"))
        wordList.add(Word("猴子", "猴子"))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter

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

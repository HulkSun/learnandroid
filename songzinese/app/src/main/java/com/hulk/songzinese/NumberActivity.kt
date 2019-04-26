package com.hulk.songzinese

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class NumberActivity : AppCompatActivity() {

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
        wordList.add(Word("零", "0", R.mipmap.number_zero, R.raw.number_one))
        wordList.add(Word("一", "1", R.mipmap.number_one, R.raw.number_one))
        wordList.add(Word("二", "2", R.mipmap.number_two, R.raw.number_one))
        wordList.add(Word("三", "3", R.mipmap.number_three, R.raw.number_one))
        wordList.add(Word("四", "4", R.mipmap.number_four, R.raw.number_one))
        wordList.add(Word("五", "5", R.mipmap.number_five, R.raw.number_one))
        wordList.add(Word("六", "6", R.mipmap.number_six, R.raw.number_one))
        wordList.add(Word("七", "7", R.mipmap.number_seven, R.raw.number_one))
        wordList.add(Word("八", "8", R.mipmap.number_eight, R.raw.number_one))
        wordList.add(Word("九", "9", R.mipmap.number_nine, R.raw.number_one))
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

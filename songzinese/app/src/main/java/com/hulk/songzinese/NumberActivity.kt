package com.hulk.songzinese

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class NumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        val wordList = ArrayList<Word>()
        wordList.add(Word("零", "0", R.mipmap.number_zero))
        wordList.add(Word("一", "1", R.mipmap.number_one))
        wordList.add(Word("二", "2", R.mipmap.number_two))
        wordList.add(Word("三", "3", R.mipmap.number_three))
        wordList.add(Word("四", "4", R.mipmap.number_four))
        wordList.add(Word("五", "5", R.mipmap.number_five))
        wordList.add(Word("六", "6", R.mipmap.number_six))
        wordList.add(Word("七", "7", R.mipmap.number_seven))
        wordList.add(Word("八", "8", R.mipmap.number_eight))
        wordList.add(Word("九", "9", R.mipmap.number_nine))
        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter
    }
}

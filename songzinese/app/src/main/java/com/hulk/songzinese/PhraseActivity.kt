package com.hulk.songzinese

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PhraseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)


        val wordList = ArrayList<Word>()
        wordList.add(Word("吃了吗", "七饭没得"))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter
    }
}

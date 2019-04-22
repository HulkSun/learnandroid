package com.hulk.songzinese

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        val wordList = ArrayList<Word>()
        wordList.add(Word("干辣椒", "辣椒皮子"))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter

    }
}

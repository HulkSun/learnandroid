package com.hulk.songzinese

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class RelationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)


        val wordList = ArrayList<Word>()
        wordList.add(Word("爸爸", "爸爸"))
        wordList.add(Word("妈妈", "妈妈"))
        wordList.add(Word("爷爷", "爷爷"))
        wordList.add(Word("奶奶", "奶奶"))
        wordList.add(Word("叔叔", "叔叔"))
        wordList.add(Word("阿姨", "阿姨"))
        wordList.add(Word("哥哥", "哥哥"))
        wordList.add(Word("姐姐", "姐姐"))
        wordList.add(Word("弟弟", "弟弟"))
        wordList.add(Word("妹妹", "妹妹"))
        wordList.add(Word("老公", "老公"))
        wordList.add(Word("老婆", "老婆"))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter
    }
}

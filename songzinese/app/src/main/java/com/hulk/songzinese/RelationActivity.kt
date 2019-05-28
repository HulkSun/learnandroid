package com.hulk.songzinese

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class RelationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        val wordList = ArrayList<Word>()
        wordList.add(Word("爸爸", "爸爸", R.drawable.man_1f468))
        wordList.add(Word("妈妈", "妈妈", R.drawable.woman_1f469))
        wordList.add(Word("爷爷", "爷爷", R.drawable.grandpa_1f474))
        wordList.add(Word("奶奶", "奶奶", R.drawable.grandma_1f475))
        wordList.add(Word("叔叔", "叔叔", R.drawable.man_1f468))
        wordList.add(Word("阿姨", "阿姨", R.drawable.woman_1f469))
        wordList.add(Word("哥哥", "哥哥", R.drawable.boy_1f466))
        wordList.add(Word("姐姐", "姐姐", R.drawable.girl_1f467))
        wordList.add(Word("弟弟", "弟弟", R.drawable.baby_1f476))
        wordList.add(Word("妹妹", "妹妹", R.drawable.baby_1f476))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter
        listView.setBackgroundColor(resources.getColor(R.color.colorRelation))

    }
}

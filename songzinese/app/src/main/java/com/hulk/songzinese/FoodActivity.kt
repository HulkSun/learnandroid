package com.hulk.songzinese

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        val wordList = ArrayList<Word>()
        wordList.add(Word("米饭", "米饭"))
        wordList.add(Word("汤圆", "汤圆"))
        wordList.add(Word("饺子", "饺子"))
        wordList.add(Word("包子", "包子"))
        wordList.add(Word("面条", "面条"))
        wordList.add(Word("茄子", "茄子"))
        wordList.add(Word("包菜", "包菜"))
        wordList.add(Word("辣椒", "辣椒"))
        wordList.add(Word("洋芋", "洋芋"))
        wordList.add(Word("豇豆", "豇豆"))
        wordList.add(Word("西瓜", "西瓜"))
        wordList.add(Word("苹果", "苹果"))
        wordList.add(Word("香蕉", "香蕉"))
        wordList.add(Word("菠萝", "菠萝"))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter

    }
}

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
        wordList.add(Word("米饭", "米饭",R.drawable.rice_1f35a))
        wordList.add(Word("饺子", "饺子",R.drawable.dumpling_1f95f))
        wordList.add(Word("面条", "面条",R.drawable.noodles_1f35c))
        wordList.add(Word("茄子", "茄子",R.drawable.aubergine_1f346))
        wordList.add(Word("辣椒", "辣椒",R.drawable.pepper_1f336))
        wordList.add(Word("洋芋", "洋芋",R.drawable.potato_1f954))
        wordList.add(Word("西瓜", "西瓜",R.drawable.watermelon_1f349))
        wordList.add(Word("苹果", "苹果",R.drawable.apple_1f34e))
        wordList.add(Word("香蕉", "香蕉",R.drawable.banana_1f34c))
        wordList.add(Word("菠萝", "菠萝",R.drawable.pineapple_1f34d))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter
        listView.setBackgroundColor(resources.getColor(R.color.colorFood))

    }
}

package com.hulk.songzinese

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PhraseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)


        val wordList = ArrayList<Word>()
        wordList.add(Word("妈妈，我肚子饿了，我想吃一个西瓜。", "妈妈，我肚子饿了，我想吃一个西瓜。"))
        wordList.add(Word("我昨天在街上碰到你爷爷了。", "我昨天在街上碰到你爷爷了。"))
        wordList.add(Word("你的哥哥怎么还没回来，给他打个电话。", "你的哥哥怎么还没回来，给他打个电话。"))
        wordList.add(Word("我今天请你吃早饭。", "我今天请你吃早饭。"))
        wordList.add(Word("今天晚上好像要下雨了，快把衣服收进来。", "今天晚上好像要下雨了，快把衣服收进来。"))
        wordList.add(Word("你吃饭没有啊，来一起吃点吧。", "你吃饭没有啊，来一起吃点吧。"))
        wordList.add(Word("我最喜欢吃辣椒炒肉了。", "我最喜欢吃辣椒炒肉了。"))
        wordList.add(Word("我们每天带你去动物园看狮子和老虎。", "我们每天带你去动物园看狮子和老虎。"))

        val wordAdapter = WordAdapter(this, R.layout.word_item, wordList)
        val listView = findViewById<ListView>(R.id.word_list_view)
        listView.adapter = wordAdapter
    }
}

package com.hulk.songzinese

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import kotlinx.android.synthetic.main.word_item.view.*

class WordAdapter(context: Context, resource: Int, wordList: ArrayList<Word>) :
    ArrayAdapter<Word>(context, resource, wordList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.word_item, parent, false)
        val word = getItem(position)
        if (word != null) {
            if (word.hasImageResourceId())
                view.word_image_view.setImageResource(word.getImageResourceId())
            else
                view.word_image_view.visibility = View.GONE

            view.songzi_text_view.text = word.getWordInSongzi()
            view.mandrain_text_view.text = word.getWordInMandrain()
        }
        return view

    }
}
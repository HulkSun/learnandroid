package com.hulk.songzinese

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animal_button.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, AnimalActivity::class.java)
            startActivity(intent)
        }

        food_button.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, FoodActivity::class.java)
            startActivity(intent)
        }
        relation_button.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, RelationActivity::class.java)
            startActivity(intent)
        }
        phrase_button.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, PhraseActivity::class.java)
            startActivity(intent)
        }
    }
}

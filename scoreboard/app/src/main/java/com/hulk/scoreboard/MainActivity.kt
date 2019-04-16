package com.hulk.scoreboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        team_a_add_1_button.setOnClickListener {
            AScore += 1
            updateScoreOfA()
        }

        team_a_add_2_button.setOnClickListener {
            AScore += 2
            updateScoreOfA()
        }

        team_a_add_3_button.setOnClickListener {
            AScore += 3
            updateScoreOfA()
        }

        team_b_add_1_button.setOnClickListener {
            BScore += 1
            updateScoreOfB()
        }

        team_b_add_2_button.setOnClickListener {
            BScore += 2
            updateScoreOfB()
        }

        team_b_add_3_button.setOnClickListener {
            BScore += 3
            updateScoreOfB()
        }

        reset_button.setOnClickListener {
            reset()
        }
    }

    var AScore = 0
    var BScore = 0


    private fun updateScoreOfA() {
        team_a_score_text_view.text = AScore.toString()
    }

    private fun updateScoreOfB() {
        team_b_score_text_view.text = BScore.toString()
    }


    private fun reset() {
        AScore = 0
        BScore = 0
        updateScoreOfA()
        updateScoreOfB()
    }
}

package com.dudu.scorekeeper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var mScore1 = 0
    private var mScore2 = 0

    private lateinit var mTvTeam1Count:TextView
    private lateinit var mTvTeam2Count:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
    }

    private fun initComponent(){
        mTvTeam1Count = findViewById(R.id.tvTeam1Count)
        mTvTeam2Count = findViewById(R.id.tvTeam2Count)
    }

    fun decreaseScore(view:View){
        when (view.id) {
            R.id.imgBtnDecreaseTeam1 -> {
                mScore1--
                mTvTeam1Count.text = mScore1.toString()
            }

            R.id.imgBtnDecreaseTeam2 -> {
                mScore2--
                mTvTeam2Count.text = mScore2.toString()
            }
        }
    }

    fun increaseScore(view:View) {
        when (view.id){
            R.id.imgBtnIncreaseTeam1 -> {
                mScore1++
                mTvTeam1Count.text = mScore1.toString()
            }
            R.id.imgBtnIncreaseTeam2 -> {
                mScore2++
                mTvTeam2Count.text = mScore2.toString()
            }
        }
    }
}

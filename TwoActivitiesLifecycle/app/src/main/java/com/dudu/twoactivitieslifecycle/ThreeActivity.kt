package com.dudu.twoactivitieslifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThreeActivity : AppCompatActivity() {

    private lateinit var tvMsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        getData()
    }

    fun getData(){
        var intent: Intent = intent
        var msg: String = intent.getStringExtra(EXTRA_MESSAGE_SECONDACTIVITY)
        tvMsg = findViewById<TextView>(R.id.tvMsg)
        tvMsg.text = msg
    }
}

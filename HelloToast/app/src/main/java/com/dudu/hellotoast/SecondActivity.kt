package com.dudu.hellotoast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)

        setData()
    }

    fun setData(){
        var intent: Intent = intent
        var bundle: Bundle = intent.getBundleExtra(MAINACTIVITY_MESSAGE)
        tv1.text = bundle.getString("SayWhat", "No What")
        tv2.text = bundle.getInt("Count").toString()
    }
}

package com.dudu.hellocompat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var txColors:IntArray
    private lateinit var tvMsg:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
    }

    private fun initComponent(){
        txColors = this.resources.getIntArray(R.array.TvTxColorList)

        tvMsg = findViewById(R.id.tvMsg)
    }

    fun chgColor(@Suppress("UNUSED_PARAMETER")view: View){

        val txColor = txColors[(Math.random() * txColors.size).toInt()]
        tvMsg.setTextColor(txColor)
    }
}

package com.dudu.hellocompat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var txColors: IntArray
    private lateinit var tvMsg: TextView
    private val bundleKeyTxColor: String = "txColor"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()

        if (savedInstanceState != null) {
            tvMsg.setTextColor(savedInstanceState.getInt(bundleKeyTxColor))
        }

    }

    private fun initComponent() {
        txColors = resources.getIntArray(R.array.TvTxColorList)
        tvMsg = findViewById(R.id.tvMsg)
    }

    fun chgColor(@Suppress("UNUSED_PARAMETER") view: View) {

        val txColor = txColors[(Math.random() * txColors.size).toInt()]
        tvMsg.setTextColor(txColor)
    }

    fun togoOtherMethod(@Suppress("UNUSED_PARAMETER") view: View) {
        startActivity(Intent().setClass(this, Main2Activity::class.java))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

//        if (outState != null) {
//            outState.putInt(bundleKeyTxColor, tvMsg.currentTextColor)
//        }
        //Abbreviation above
        outState?.putInt(bundleKeyTxColor, tvMsg.currentTextColor)
    }
}

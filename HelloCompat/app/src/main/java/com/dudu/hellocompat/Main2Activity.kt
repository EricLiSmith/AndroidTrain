package com.dudu.hellocompat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import java.util.*

class Main2Activity : AppCompatActivity() {
    private val txColors = arrayOf("Black", "Red", "Lime", "Blue", "Yellow", "Cyan", "Magenta", "Silver", "Gray", "Maroon", "Olive", "Green")
    private lateinit var tvMsg: TextView
    private val bundleKeyTxColor:String = "txMain2Color"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initComponent()

        if (savedInstanceState != null) {
            tvMsg.setTextColor(savedInstanceState.getInt(bundleKeyTxColor))
        }

    }

    private fun initComponent(){
        tvMsg = findViewById(R.id.tvMsg)
    }

    fun chgColor(@Suppress("UNUSED_PARAMETER")view: View){

        val random = Random()
        val colorName:String = txColors[random.nextInt(12)]
        val colorResourceName = resources.getIdentifier(colorName, "color", applicationContext.packageName)
        //Call requires API level 23 (current min is 15)
//        val colorRes = resources.getColor(colorResourceName, this.theme)
        val colorRes = ContextCompat.getColor(this, colorResourceName)
        tvMsg.setTextColor(colorRes)
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

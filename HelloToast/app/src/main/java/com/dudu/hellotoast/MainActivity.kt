package com.dudu.hellotoast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

const val MAINACTIVITY_MESSAGE = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var mCount = 0;
    private lateinit var mShowCount:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.tvShowCount)

        if (mShowCount != null) {
            mShowCount.setText(mCount.toString())
        }
    }

    fun showToast(view: View){
//        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        var intent: Intent = intent.setClass(this, SecondActivity::class.java)
        var bundle: Bundle = Bundle()
        bundle.putString("SayWhat", "Hello")
        bundle.putInt("Count", mCount)
        intent.putExtra(MAINACTIVITY_MESSAGE, bundle)
        startActivity(intent)
    }

    fun countUp(view: View){
        mCount++
        mShowCount.setText(mCount.toString())
    }
}

package com.dudu.hellotoast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

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
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countUp(view: View){
        mCount++
        mShowCount.setText(mCount.toString())
    }
}

package com.dudu.helloconstraint

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var mCount = 0;
    private lateinit var mShowCount:TextView
    private lateinit var mbtnCount:Button
    private lateinit var mbtnReset:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.tvShowCount)
        mbtnCount = findViewById(R.id.btn_count)
        mbtnReset = findViewById(R.id.btn_zero)

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

        if (mCount % 2 == 0) { //偶數 even
            view.setBackgroundColor(Color.MAGENTA)
        } else { //奇數 odd
            view.setBackgroundColor(Color.GREEN)
        }


        mbtnReset.setBackgroundColor(Color.RED);
    }

    fun countReset(view: View){
        mCount = 0
        mShowCount.setText(mCount.toString())

        view.setBackgroundColor(Color.GRAY);
        mbtnCount.setBackgroundColor(Color.BLUE);
    }
}

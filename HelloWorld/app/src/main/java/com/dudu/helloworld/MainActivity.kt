package com.dudu.helloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    val LOG_TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(LOG_TAG, "This is verbose level log")
        Log.d(LOG_TAG,"Hello Word, This is debug level log")
        Log.i(LOG_TAG, "This is info level log")
        Log.w(LOG_TAG, "This is Warning level log")
        Log.e(LOG_TAG,"This is error level log")
    }
}

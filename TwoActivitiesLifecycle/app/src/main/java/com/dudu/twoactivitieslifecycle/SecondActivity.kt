package com.dudu.twoactivitieslifecycle

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val EXTRA_MESSAGE_SECONDACTIVITY:String = "SecondActivity"

class SecondActivity : AppCompatActivity() {
    private val LOG_TAG:String = this.javaClass.name
    private lateinit var etReplyData:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        etReplyData = findViewById(R.id.etReplyData)
        getData()

        Log.d(LOG_TAG, "******---------******")
        Log.d(LOG_TAG, "OnCreate")
    }

    fun getData(){
        var intent: Intent = intent
        var msg: String = intent.getStringExtra(EXTRA_MESSAGE_MAINACTIVITY)
        var tvReceivedMsg = findViewById<TextView>(R.id.tvReceivedMsg)
        tvReceivedMsg.text = msg

        Log.d(LOG_TAG, msg)
    }

    fun returnReply(view: View) {
        var intent = Intent()
        var replyMsg:String = etReplyData.text.toString()
        intent.putExtra(EXTRA_MESSAGE_SECONDACTIVITY, replyMsg)
        setResult(Activity.RESULT_OK, intent)
        finish()

        Log.d(LOG_TAG, "End SecondActivity, back to MainActivity")
    }

//    fun getScroollViewIntent() = {var intent = Intent().setClass(this, ThreeActivity::class.java)}

    fun gotoScroollViewIntent(msg:String) {
        var intent = Intent().setClass(this, ThreeActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE_SECONDACTIVITY, msg)
        startActivity(intent)
    }

    fun btn2ToScroollView(view: View) {
        gotoScroollViewIntent(getString(R.string.Two_article))
    }

    fun btn1ToScroollView(view: View) {
        gotoScroollViewIntent(getString(R.string.One_article))
    }

    fun btn3ToScroollView(view: View) {
        gotoScroollViewIntent(getString(R.string.Three_article))
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "OnReStart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "OnDestroy")
    }


}

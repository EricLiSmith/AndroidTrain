package com.dudu.twoactivities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val LOG_TAG:String = "Twoactivitys"
const val EXTRA_MESSAGE_MAINACTIVITY:String = "MainActivity"
const val TEXT_REQUEST:Int = 1
class MainActivity : AppCompatActivity() {

    private lateinit var etData:EditText
    private lateinit var tvTextReplyTextHeader:TextView
    private lateinit var tvTextReply:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etData = findViewById(R.id.etData)
        tvTextReplyTextHeader = findViewById(R.id.tvTextReplyTextHeader)
        tvTextReply = findViewById(R.id.tvTextReply)
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        val message: String = etData.text.toString()

        val intent = Intent()
        intent.setClass(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE_MAINACTIVITY, message)
//        startActivity(intent)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK && data != null){
                var replyMsg:String = data.getStringExtra(EXTRA_MESSAGE_SECONDACTIVITY)
                tvTextReplyTextHeader.visibility = View.VISIBLE
                tvTextReply.visibility = View.VISIBLE
                tvTextReply.text = replyMsg
            }
        }
    }
}

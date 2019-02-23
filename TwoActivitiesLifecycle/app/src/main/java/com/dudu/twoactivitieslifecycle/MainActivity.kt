package com.dudu.twoactivitieslifecycle

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val EXTRA_MESSAGE_MAINACTIVITY:String = "MainActivity"
const val TEXT_REQUEST:Int = 1
class MainActivity : AppCompatActivity() {
    private val LOG_TAG:String = this.javaClass.name
    private lateinit var etData:EditText
    private lateinit var tvTextReplyTextHeader:TextView
    private lateinit var tvTextReply:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etData = findViewById(R.id.etData)
        tvTextReplyTextHeader = findViewById(R.id.tvTextReplyTextHeader)
        tvTextReply = findViewById(R.id.tvTextReply)

        Log.d(LOG_TAG, "******---------******")
        Log.d(LOG_TAG, "OnCreate")

        //Restore the state
        if(savedInstanceState != null) {
            if(savedInstanceState.getBoolean("reply_visible")) {
                tvTextReplyTextHeader.visibility = View.VISIBLE
                tvTextReply.text = savedInstanceState.getString("reply_text")
                tvTextReply.visibility = View.VISIBLE
            }
        }
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


    //onPause ==> onStop
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        if (outState != null) {
            if (tvTextReplyTextHeader.visibility == View.VISIBLE) {
                outState.putBoolean("reply_visible", true)
                outState.putString("reply_text", tvTextReply.text.toString())
            }
        }
    }

    fun goToShopping(view: View) {
        var intent:Intent = Intent()
        intent.setClass(this, ShoppingActivity::class.java)
        startActivity(intent)
    }
}

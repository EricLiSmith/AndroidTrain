package com.dudu.implicitintentsreceiver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textUriMessage:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
        if (intent != null) {
            processReceivedImplicitIntent()
        }
    }

    private fun initComponent(){
        textUriMessage = findViewById(R.id.text_uri_message)
    }

    private fun processReceivedImplicitIntent(){
        val intent = intent
        val uri = intent.data
        var uriString = ""
        if (uri != null) {
            uriString = "URI:$uri"
        }

        textUriMessage.text = uriString
    }
}

package com.dudu.droidcafe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OrderActivity : AppCompatActivity() {

    private lateinit var tvOrderItem:TextView
    private var orderItem = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        initComponent()

        if (intent != null) {
            orderItem = intent.getStringExtra(EXTRA_MESSAGE_ORDER)
            tvOrderItem.text = orderItem
        }
    }

    private fun initComponent(){
        tvOrderItem = findViewById(R.id.tvOrderItem)
    }
}

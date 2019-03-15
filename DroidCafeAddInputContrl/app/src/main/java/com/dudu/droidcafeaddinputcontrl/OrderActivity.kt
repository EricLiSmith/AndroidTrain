package com.dudu.droidcafeaddinputcontrl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class OrderActivity : AppCompatActivity() {

    private lateinit var tvOrderItem:TextView
    private var orderItem = ""
    private lateinit var rBtnSmoeDay:RadioButton
    private lateinit var rBtnNextDay:RadioButton
    private lateinit var rBtnPickUp:RadioButton

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
        rBtnSmoeDay = findViewById(R.id.rBtnSmoeDay)
        rBtnNextDay = findViewById(R.id.rBtnNextDay)
        rBtnPickUp = findViewById(R.id.rBtnPickUp)

        rBtnNextDay.isChecked = true
    }

    fun onRadioBtnClicked(view: View){
        val checked = (view as RadioButton).isChecked

        when (checked) {
            view.id == R.id.rBtnSmoeDay -> displayToast(getString(R.string.rBtnSmoeDay))
            view.id == R.id.rBtnNextDay -> displayToast(getString(R.string.rBtnNextDay))
            view.id == R.id.rBtnPickUp  -> displayToast(getString(R.string.rBtnPickUp))
            else -> displayToast("Not select any item")
        }


    }

    private fun displayToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}

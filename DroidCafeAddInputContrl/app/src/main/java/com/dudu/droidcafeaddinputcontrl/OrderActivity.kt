package com.dudu.droidcafeaddinputcontrl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

@Suppress("SENSELESS_COMPARISON")
class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var tvOrderItem: TextView
    private var orderItem = ""
    private lateinit var rBtnSmoeDay: RadioButton
    private lateinit var rBtnNextDay: RadioButton
    private lateinit var rBtnPickUp: RadioButton
    private lateinit var spPhoneType: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        initComponent()

        if (intent != null) {
            orderItem = intent.getStringExtra(EXTRA_MESSAGE_ORDER)
            tvOrderItem.text = orderItem
        }
    }


    private fun initComponent() {
        tvOrderItem = findViewById(R.id.tvOrderItem)
        rBtnSmoeDay = findViewById(R.id.rBtnSmoeDay)
        rBtnNextDay = findViewById(R.id.rBtnNextDay)
        rBtnPickUp = findViewById(R.id.rBtnPickUp)
        spPhoneType = findViewById(R.id.spPhoneType)

        rBtnNextDay.isChecked = true

        if (spPhoneType != null) {
            spPhoneType.onItemSelectedListener = this

            // Create ArrayAdapter using the string array and default spinner layout.
            val adapter = ArrayAdapter.createFromResource(this, R.array.phone_type, android.R.layout.simple_spinner_item)
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spPhoneType.adapter = adapter
        }
    }

    fun onRadioBtnClicked(view: View) {
        val checked = (view as RadioButton).isChecked

        when (checked) {
            view.id == R.id.rBtnSmoeDay -> displayToast(getString(R.string.rBtnSmoeDay))
            view.id == R.id.rBtnNextDay -> displayToast(getString(R.string.rBtnNextDay))
            view.id == R.id.rBtnPickUp -> displayToast(getString(R.string.rBtnPickUp))
            else -> displayToast("Not select any item")
        }


    }

    private fun displayToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //To change body of created functions use File | Settings | File Templates.

        if (parent != null) {
            val spinnerTxt = parent.getItemAtPosition(position).toString()
            displayToast(spinnerTxt)
        }
    }
}

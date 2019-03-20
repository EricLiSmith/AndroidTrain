package com.dudu.passtophone

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener {
    private val logTAG = "MainActivity"
    private lateinit var etPhoneNumber: EditText

    private var checkedItems = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCompnent()
    }

    private fun initCompnent() {
        etPhoneNumber = findViewById(R.id.etPhoneNumber)

        etPhoneNumber.setOnEditorActionListener(this)
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        //To change body of created functions use File | Settings | File Templates.
        var handled = false

        if (actionId == EditorInfo.IME_ACTION_SEND) {
            dialNumber()
            handled = true
        }

        return handled
    }

    private fun dialNumber() {
        val phoneNum = "tel:" + etPhoneNumber.text.toString()

        Log.d(logTAG, "dialNumber: $phoneNum")

        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(phoneNum)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(logTAG, "Can't handle this!")
        }
    }

    fun addCheckItem(view: View){
        checkedItems += (view as CheckBox).text.toString()
    }

    fun showCheckedItems(@Suppress("UNUSED_PARAMETER")view: View){
        Toast.makeText(this, checkedItems, Toast.LENGTH_SHORT).show()
    }
}

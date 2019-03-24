package com.dudu.pickerfordate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePicker(@Suppress("UNUSED_PARAMETER")view: View){
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    fun processDatePickerResult(year:Int, month:Int, day:Int) {
        val monthStr = (month+1).toString()
        val dayStr = day.toString()
        val yearStr = year.toString()
        val dateMsg = "$monthStr / $dayStr / $yearStr"

        Toast.makeText(this, "Date: $dateMsg", Toast.LENGTH_SHORT).show()
    }
}

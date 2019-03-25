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

    fun showTimePicker(@Suppress("UNUSED_PARAMETER")view:View) {
        val timeFragment = TimePickerFragment()
        timeFragment.show(supportFragmentManager, "timePicker")
    }

    fun processTimePickerResult(hour:Int, minute:Int){
        val hourStr = hour.toString()
        val minuteStr = minute.toString()
        val timeMsg = "$hourStr : $minuteStr"
        Toast.makeText(this, "Time : $timeMsg", Toast.LENGTH_SHORT).show()
    }
}

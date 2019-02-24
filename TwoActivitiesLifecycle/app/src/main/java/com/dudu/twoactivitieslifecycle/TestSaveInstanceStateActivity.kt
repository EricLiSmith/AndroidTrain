package com.dudu.twoactivitieslifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class TestSaveInstanceStateActivity : AppCompatActivity() {
    private val outStateKeyCount = "Count"
    private var count:Int = 0
    private lateinit var tvCount:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_save_instance_state)
        initComponent()

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(outStateKeyCount)
            tvCount.text = count.toString()
        }
    }

    fun initComponent(){
        tvCount = findViewById(R.id.tvCount)
    }

    fun countNumber(@Suppress("UNUSED_PARAMETER")view:View) {
        count++
        tvCount.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

//        if (outState != null) {
//            outState.putInt(outStateKeyCount, count)
//        }

        //expression code
        outState?.putInt(outStateKeyCount, count)
    }
}

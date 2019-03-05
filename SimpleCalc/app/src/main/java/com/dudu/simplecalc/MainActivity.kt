package com.dudu.simplecalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etNum1:EditText
    private lateinit var etNum2:EditText
    private lateinit var tvNumResult:TextView
    private var iNumTotal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
    }

    private fun initComponent(){
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        tvNumResult = findViewById(R.id.tvNumResult)
    }


    fun toPlusNum(@Suppress("UNUSED_PARAMETER")view:View){ //+
        iNumTotal = editViewToNum(etNum1).plus(editViewToNum(etNum2))
        showNumResult()
    }

    fun toSubNumber(@Suppress("UNUSED_PARAMETER")view:View){ //-
        iNumTotal = editViewToNum(etNum1).minus(editViewToNum(etNum2))
        showNumResult()
    }

    fun toMulNum(@Suppress("UNUSED_PARAMETER")view: View){ //*
        iNumTotal = editViewToNum(etNum1).times(editViewToNum(etNum2))
        showNumResult()
    }

    fun toDivNum(@Suppress("UNUSED_PARAMETER")view:View){ // /
        iNumTotal = editViewToNum(etNum1).div(editViewToNum(etNum2))
        showNumResult()
    }

    private fun editViewToNum(et:EditText) = et.text.toString().toInt()
    private fun showNumResult(){
        tvNumResult.text = iNumTotal.toString()
    }

}

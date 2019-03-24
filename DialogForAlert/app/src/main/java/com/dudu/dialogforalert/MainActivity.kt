package com.dudu.dialogforalert

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showAlert(@Suppress("UNUSED_PARAMETER")view: View) {
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("Alert")
        dialog.setMessage("Click OK to continue, or Cancel to stop")
        dialog.setPositiveButton("OK") {
            _,_ ->  Toast.makeText(this, "Pressed OK", Toast.LENGTH_SHORT).show()
        }

        dialog.setNegativeButton("Cancel") {
            _,_ -> Toast.makeText(this, "Pressed Cancel", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }
}

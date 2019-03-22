package com.dudu.droidcafeaddinputcontrl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ContextActivity : AppCompatActivity() {

    private lateinit var tvContent:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)
        initComponent()
    }

    private fun initComponent(){
        tvContent = findViewById(R.id.tvContent)

        registerForContextMenu(tvContent)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item != null) {
            when (item.itemId) {
                R.id.cmEdit -> {
                    displayToast(getString(R.string.ContentMenuEdit))
                    true
                }
                R.id.cmShare -> {
                    displayToast(getString(R.string.ContentMenuShare))
                    true
                }
                R.id.cmDelete -> {
                    displayToast(getString(R.string.ContentMenuDelete))
                    true
                }
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun displayToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}

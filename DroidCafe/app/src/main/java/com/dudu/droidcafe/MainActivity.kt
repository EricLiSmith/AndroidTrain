package com.dudu.droidcafe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE_ORDER = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var orderItem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showDountOrder(@Suppress("UNUSED_PARAMETER")view: View) {
        displayToast(getString(R.string.donut_order_message))
    }

    fun showIceCreamOrder(@Suppress("UNUSED_PARAMETER")view: View) {
        displayToast(getString(R.string.ice_cream_order_message))
    }

    fun showFroyoOrder(@Suppress("UNUSED_PARAMETER")view: View) {
        displayToast(getString(R.string.froyo_order_message))
    }

    fun togoOrder(@Suppress("UNUSED_PARAMETER")view :View){
        val intent = Intent().setClass(this, OrderActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE_ORDER, orderItem)
        startActivity(intent)
    }

    private fun displayToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        orderItem = msg
    }
}

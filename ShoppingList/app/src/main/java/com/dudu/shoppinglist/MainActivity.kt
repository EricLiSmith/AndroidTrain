package com.dudu.shoppinglist

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val REQ_SHOPPING = 1
const val EXTRA_DATA_SHOPPING_LIST = "ShoppingList"
const val EXTRA_DATA_ITEM_APPLE = "Apple"
const val EXTRA_DATA_ITEM_RICE = "Rice"
const val EXTRA_DATA_ITEM_CHEESE = "Cheese"
const val EXTRA_DATA_ITEM_BANANA = "Banana"
const val EXTRA_DATA_ITEM_ROLL_COOKIE = "RollCookie"
class MainActivity : AppCompatActivity() {
    private val stateDataKeyTv1 = "tv1"
    private val stateDataKeyTv2 = "tv2"
    private val stateDataKeyTv3 = "tv3"
    private val stateDataKeyTv4 = "tv4"
    private val stateDataKeyTv5 = "tv5"
    private val logTag = this.javaClass.name

    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView
    private lateinit var tv4: TextView
    private lateinit var tv5: TextView
    private lateinit var etStoreName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()



        if (savedInstanceState != null) {
            tv1.text = savedInstanceState.getString(stateDataKeyTv1)
            tv2.text = savedInstanceState.getString(stateDataKeyTv2)
            tv3.text = savedInstanceState.getString(stateDataKeyTv3)
            tv4.text = savedInstanceState.getString(stateDataKeyTv4)
            tv5.text = savedInstanceState.getString(stateDataKeyTv5)
        }
    }

    private fun initComponent(){
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
        tv4 = findViewById(R.id.tv4)
        tv5 = findViewById(R.id.tv5)
        etStoreName = findViewById(R.id.etStoreName)
    }

    fun selectItem(@Suppress("UNUSED_PARAMETER")view: View){
        val intent = Intent(this, ShoppingItemActivity::class.java)
        startActivityForResult(intent, REQ_SHOPPING)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQ_SHOPPING && data !=null) {
                val shoppingList = data.getStringExtra(EXTRA_DATA_SHOPPING_LIST)

                if (shoppingList.contains(EXTRA_DATA_ITEM_APPLE)) {
                    tv1.text = isItemCheck(tv1)
                }

                if (shoppingList.contains(EXTRA_DATA_ITEM_RICE)) {
                    tv2.text = isItemCheck(tv2)
                }

                if (shoppingList.contains(EXTRA_DATA_ITEM_CHEESE)) {
                    tv3.text = isItemCheck(tv3)
                }

                if (shoppingList.contains(EXTRA_DATA_ITEM_BANANA)) {
                    tv4.text = isItemCheck(tv4)
                }

                if (shoppingList.contains(EXTRA_DATA_ITEM_ROLL_COOKIE)) {
                    tv5.text = isItemCheck(tv5)
                }
            }
        }
    }

    private fun isItemCheck (tv: TextView) = tv.text.toString() + "is Check"

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        if(outState != null) {
            outState.putString(stateDataKeyTv1, tv1.text.toString())
            outState.putString(stateDataKeyTv2, tv2.text.toString())
            outState.putString(stateDataKeyTv3, tv3.text.toString())
            outState.putString(stateDataKeyTv4, tv4.text.toString())
            outState.putString(stateDataKeyTv5, tv5.text.toString())
        }
    }

    fun toFindStore(@Suppress("UNUSED_PARAMETER")view:View) {
        val loc = etStoreName.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(logTag, "Can't handle")
        }
    }
}

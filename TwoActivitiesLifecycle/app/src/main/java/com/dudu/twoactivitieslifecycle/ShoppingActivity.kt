package com.dudu.twoactivitieslifecycle

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

const val REQ_SHOPPING = 1
const val EXTRA_DATA_SHOPPINGLIST = "ShoppingList"
const val EXTRA_DATA_ITEM_APPLE = "Apple"
const val EXTRA_DATA_ITEM_RICE = "Rice"
const val EXTRA_DATA_ITEM_CHEESE = "Cheese"
const val EXTRA_DATA_ITEM_BANANA = "Banana"
const val EXTRA_DATA_ITEM_ROLLCOOKIE = "RollCookie"

class ShoppingActivity : AppCompatActivity() {
    private val stateDataKeyTv1 = "tv1"
    private val stateDataKeyTv2 = "tv2"
    private val stateDataKeyTv3 = "tv3"
    private val stateDataKeyTv4 = "tv4"
    private val stateDataKeyTv5 = "tv5"


    private lateinit var tv1:TextView
    private lateinit var tv2:TextView
    private lateinit var tv3:TextView
    private lateinit var tv4:TextView
    private lateinit var tv5:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
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
    }

    fun selectItem(view: View){
        var intent:Intent = Intent(this, ShoppingItemActivity::class.java)
        startActivityForResult(intent, REQ_SHOPPING)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQ_SHOPPING && data !=null) {
                var shoppinglist = data.getStringExtra(EXTRA_DATA_SHOPPINGLIST)

                if (shoppinglist.contains(EXTRA_DATA_ITEM_APPLE)) {
                    tv1.text = isItemCheck(tv1)
                }

                if (shoppinglist.contains(EXTRA_DATA_ITEM_RICE)) {
                    tv2.text = isItemCheck(tv2)
                }

                if (shoppinglist.contains(EXTRA_DATA_ITEM_CHEESE)) {
                    tv3.text = isItemCheck(tv3)
                }

                if (shoppinglist.contains(EXTRA_DATA_ITEM_BANANA)) {
                    tv4.text = isItemCheck(tv4)
                }

                if (shoppinglist.contains(EXTRA_DATA_ITEM_ROLLCOOKIE)) {
                    tv5.text = isItemCheck(tv5)
                }
            }
        }
    }

    private fun isItemCheck (tv:TextView) = tv.text.toString() + "is Check"

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
}

package com.dudu.twoactivitieslifecycle

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView



class ShoppingItemActivity : AppCompatActivity() {
    private val LOG_TAG:String = this.javaClass.name
    private var shoppingList:String = ""
    private lateinit var tvShoppingList:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_item)
        initComponent()

    }

    private fun initComponent(){
        tvShoppingList = findViewById(R.id.tvShoppingList)
    }


    fun checkApple(@Suppress("UNUSED_PARAMETER")view:View){
        appendShoppingList(EXTRA_DATA_ITEM_APPLE)
    }

    fun checkRice(@Suppress("UNUSED_PARAMETER")view:View){
        appendShoppingList(EXTRA_DATA_ITEM_RICE)
    }

    fun checkCheese(@Suppress("UNUSED_PARAMETER")view:View){
        appendShoppingList(EXTRA_DATA_ITEM_CHEESE)
    }

    fun checkBanana(@Suppress("UNUSED_PARAMETER")view:View){
        appendShoppingList(EXTRA_DATA_ITEM_BANANA)
    }

    fun checkRollCookie(@Suppress("UNUSED_PARAMETER")view:View) {
        appendShoppingList(EXTRA_DATA_ITEM_ROLLCOOKIE)
    }

    private fun appendShoppingList(item:String){
        Log.d(LOG_TAG, "appendShoppingList")
        if (shoppingList.isEmpty()) {
            shoppingList = item
            Log.d(LOG_TAG, "shoppingList is null")
        } else {
            Log.d(LOG_TAG, "shoppingList is not null")
            shoppingList += ",$item"
        }

        tvShoppingList.text = shoppingList
    }

    fun checkItem(@Suppress("UNUSED_PARAMETER")view:View) {
        val intent = Intent()
        intent.putExtra(EXTRA_DATA_SHOPPINGLIST, shoppingList)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}

package com.dudu.recyclerview

import android.os.Bundle
//import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val SAVE_KEY_RECYCLERVIEW = "mRecyclerView"
    private var mWordList = LinkedList<String>()
    private var mWordListOriginal = LinkedList<String>()
    private lateinit var mRecyclerView:RecyclerView
    private lateinit var mAdapter:WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            val wordListSize = mWordList.size
            // Add a new word to the wordList.
            mWordList.addLast("+ Word $wordListSize")
            // Notify the adapter, that the data has changed.
            mRecyclerView.adapter.notifyItemInserted(wordListSize)
            // Scroll to the bottom.
            mRecyclerView.smoothScrollToPosition(wordListSize)

        }

        initWordData()
        initComponent()
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
//            R.id.action_settings -> true
            R.id.action_reset -> {
                resetRecyclerView()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initComponent(){
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.rvViewList)
        // Create an adapter and supply the data to be displayed.
        mAdapter = WordListAdapter(this, mWordList)
        // Connect the adapter with the RecyclerView.
        mRecyclerView.adapter = mAdapter
        // Give the RecyclerView a default layout manager.
        mRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initWordData(){
        for(i in 0..20) {
            mWordList.addLast("Word $i")
            mWordListOriginal.addLast("Word $i")
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)


        if (outState != null) {
        }
    }

    private fun resetRecyclerView(){
        mWordList.clear()
        initWordData()
        mRecyclerView.adapter.notifyDataSetChanged()
    }
}

package com.dudu.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

class WordListAdapter(context: Context, wordList: LinkedList<String>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val mWordList = wordList
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return mWordList.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.

        val current = mWordList[position]
        holder.wordItemView.text = current
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListAdapter.WordViewHolder {
        //To change body of created functions use File | Settings | File Templates.

        val itemView = mInflater.inflate(R.layout.wordlist_item, parent, false)
        return WordViewHolder(itemView, this)
    }

    class WordViewHolder(itemView: View?, adapter: WordListAdapter) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val wordItemView = itemView?.findViewById(R.id.tvWord) as TextView
        private val mAdapter = adapter

        init {
            wordItemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //To change body of created functions use File | Settings | File Templates.
            // Get the position of the item that was clicked.
            val mPosition = layoutPosition
            // Use that to access the affected item in mWordList.
            val element = mAdapter.mWordList[mPosition]
            // Change the word in the mWordList.
            mAdapter.mWordList[mPosition] = "Clicked! $element"
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged()
        }
    }
}
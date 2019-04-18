package com.dudu.recyclerviewexercise

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*
const val EXTRA_OBJ_RECIPEDATA = "RECIPEDATA"
class RecipeListAdapter(context: Context, dataList: LinkedList<RecipeData>) :
    RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private val mDataList = dataList
    val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListAdapter.ViewHolder {
        //To change body of created functions use File | Settings | File Templates.
        val itemView = mInflater.inflate(R.layout.recyclerview_list, parent, false)
        return ViewHolder(itemView, this)
    }

    override fun getItemCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return mDataList.size
    }

    override fun onBindViewHolder(holder: RecipeListAdapter.ViewHolder, position: Int) {
        val recipeData = mDataList[position]//To change body of created functions use File | Settings | File Templates.
        holder.tvRecipeTitle.text = recipeData.getRecipeTitle()
        holder.tvRecipeShortDesc.text = recipeData.getRecipeDesc()
    }


    class ViewHolder(itemView: View?, private val recipeListAdapter: RecipeListAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvRecipeTitle:TextView = itemView?.findViewById(R.id.tvRecipeTitle) as TextView
        val tvRecipeShortDesc:TextView = itemView?.findViewById(R.id.tvRecipeShortDesc) as TextView

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //To change body of created functions use File | Settings | File Templates.
            val position = layoutPosition
            val recipeData = recipeListAdapter.mDataList[position]

            val intent = Intent(recipeListAdapter.mContext, RecipeDetailActivity::class.java)
            intent.putExtra(EXTRA_OBJ_RECIPEDATA, recipeData)
            recipeListAdapter.mContext.startActivity(intent)
        }
    }
}
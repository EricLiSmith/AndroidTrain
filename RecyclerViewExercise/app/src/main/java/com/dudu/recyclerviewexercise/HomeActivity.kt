package com.dudu.recyclerviewexercise

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : BaseActivity() {

    private var mRecipeDataList = LinkedList<RecipeData>()
    private lateinit var rvList: RecyclerView
    private lateinit var mAdapter: RecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)
        // Note that the Toolbar defined in the layout has the id "toolbar"
        setSupportActionBar(toolbar)

        initRecipeList()
        initComponent()
    }

    private fun initRecipeList() {
        val recipeTiles = resources.getStringArray(R.array.RecipeTitles)
        val recipeDescs = resources.getStringArray(R.array.RecipeDescs)
        val recipeDetails = resources.getStringArray(R.array.RecipeDetails)
        val recipeImgIds = resources.obtainTypedArray(R.array.RecipeImgIds)


        for (i in recipeTiles.indices) {
            mRecipeDataList.add(RecipeData(recipeTiles[i], recipeDescs[i], recipeDetails[i], recipeImgIds.getResourceId(i,-1)))
        }
    }

    private fun initComponent() {
        rvList = findViewById(R.id.rvList)
        mAdapter = RecipeListAdapter(this, mRecipeDataList)
        rvList.adapter = mAdapter
        rvList.layoutManager = LinearLayoutManager(this)
    }


}
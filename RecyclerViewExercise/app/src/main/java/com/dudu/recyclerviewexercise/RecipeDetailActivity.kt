package com.dudu.recyclerviewexercise

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*

class RecipeDetailActivity : BaseActivity() {
    private lateinit var recipeData: RecipeData
    private lateinit var ivRecipe: ImageView
    private lateinit var tvRecipeDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipedetail)
        // my_child_toolbar is defined in the layout file
        setSupportActionBar(toolbar)
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        initComponent()
    }

    private fun initComponent() {
        recipeData = intent.getSerializableExtra(EXTRA_OBJ_RECIPEDATA) as RecipeData
        ivRecipe = findViewById(R.id.ivRecipe)
        tvRecipeDetail = findViewById(R.id.tvRecipeDetail)

        ivRecipe.setImageResource(recipeData.getRecipeImgId())
        tvRecipeDetail.text = recipeData.getRecipeDetail()
    }
}
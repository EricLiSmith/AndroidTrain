package com.dudu.recyclerviewexercise

import java.io.Serializable

class RecipeData(
    private val recipeTitle: String,
    private var recipeDesc: String,
    private var recipeDetail: String,
    private var recipeImgId: Int) : Serializable {

    fun getRecipeTitle(): String {
        return recipeTitle
    }

    fun getRecipeDesc(): String {
        return recipeDesc
    }

    fun getRecipeDetail():String {
        return recipeDetail
    }

    fun getRecipeImgId():Int {
        return recipeImgId
    }
}
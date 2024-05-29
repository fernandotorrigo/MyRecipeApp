package com.ftorrigo.myrecipeapp.data.api

import com.ftorrigo.myrecipeapp.model.CategoryResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(Api::class.java)

interface Api {

    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse
}
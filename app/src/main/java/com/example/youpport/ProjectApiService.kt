package com.example.youpport

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProjectApiService {
    @GET("data/{category}")
    fun getDataByCategory(@Path("category") category: String): Call<List<List<ProjectDto>>>


}


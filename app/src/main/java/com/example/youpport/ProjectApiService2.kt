package com.example.youpport

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProjectApiService2 {

    @GET("data/{category}")
    fun getDataByCategory2(@Path("category") category: String): Call<List<ProjectDto>>
}
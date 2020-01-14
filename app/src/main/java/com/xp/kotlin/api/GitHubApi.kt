package com.xp.kotlin.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner")owner:String,@Path("repo")repo:String ):Call<Repository>
}
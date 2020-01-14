package com.xp.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xp.kotlin.api.GitHubApi
import com.xp.kotlin.api.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gitHubApi = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(GitHubApi::class.java)

        gitHubApi.getRepository("JetBrains", "Kotlin").enqueue(object : Callback<Repository> {
            override fun onFailure(call: Call<Repository>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Repository>, response: Response<Repository>) {
                val repository = response.body()
                if (repository == null) {
                    println("Error")
                } else {
                    println(repository.name)
                    println(repository.owner.login)
                }
            }

        })


    }


}

package com.xp.kotlin

import com.xp.kotlin.api.GitHubApi
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)


        val gitHubApi = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(GitHubApi::class.java)

        val response = gitHubApi.getRepository("JetBrains", "Kotlin").execute()

        val repository = response.body()
        if (repository == null) {
            println("Error")
        } else {
            println(repository.name)
            println(repository.owner.login)
        }


    }
}

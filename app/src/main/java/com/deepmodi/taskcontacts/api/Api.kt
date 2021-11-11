package com.deepmodi.taskcontacts.api

import com.deepmodi.taskcontacts.models.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("users")
    suspend fun getAllContacts(
        @Query("page")
        page : String = "2"): Response<Users>
}
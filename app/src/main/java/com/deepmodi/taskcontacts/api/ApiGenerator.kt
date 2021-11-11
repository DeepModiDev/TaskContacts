package com.deepmodi.taskcontacts.api

import android.os.Build
import androidx.databinding.ktx.BuildConfig
import com.deepmodi.taskcontacts.common.Common
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiGenerator {
    companion object{
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder().apply {
                baseUrl(Common.BASE_URL)
                addConverterFactory(GsonConverterFactory.create())
                if(BuildConfig.DEBUG) {
                    client(client)
                }
            }.build()
        }

        val api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}
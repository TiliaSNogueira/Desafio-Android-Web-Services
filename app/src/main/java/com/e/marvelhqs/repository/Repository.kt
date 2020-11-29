package com.e.marvelhqs.repository

import com.e.marvelhqs.ComicsWrapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Service {

    //diz que vou pegar comics, e passa a chave
    @GET("comics?ts=1&apikey=de99d1f85bca19d7f67799a145912104&hash=b2f3a542ff1d531011ebaf6da5efc591")
    suspend fun getLisHQRepo(): ComicsWrapper
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com/v1/public/characters/1011334/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val service: Service = retrofit.create(Service::class.java)


//http://gateway.marvel.com/v1/public/characters/1011334/


//@GET("characters?ts=1&apikey=f28a07f38dc7090aa24b3e50496e6ac6&hash=f7aece34f231420e8d8fb2e698fa4113")
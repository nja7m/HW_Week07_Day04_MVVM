package com.twq.w7_day4_mvvm.network

import com.twq.w7_day4_mvvm.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

	@GET("User")
	fun getUserByUsernameAndPassword(
		@Query("username") username: String,
		@Query("password") password: String
	): Call<List<User>>

	@POST("User")
	fun postUser(@Body user: User): Call<User>

	@GET("User")
	fun getAllUsers(): Call<List<User>>

}
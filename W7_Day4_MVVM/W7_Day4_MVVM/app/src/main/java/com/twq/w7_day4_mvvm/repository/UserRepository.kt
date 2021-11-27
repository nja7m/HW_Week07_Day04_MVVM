package com.twq.w7_day4_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.network.Api
import com.twq.w7_day4_mvvm.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    var userService = Api.getInstance().create(UserService::class.java)

    fun login(username: String, password: String): LiveData<User> {
        var mLiveData = MutableLiveData<User>()

        userService.getUserByUsernameAndPassword(username, password)
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    var listOfUsera = response.body()
                    if (listOfUsera?.isNotEmpty() == true) {
                        mLiveData.postValue(listOfUsera[0])
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        return mLiveData
    }

//    fun register(user: User): LiveData<User> {
//        return
//    }

}
package com.twq.w7_day4_mvvm.view.registeration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.repository.UserRepository

class RegisterViewModel {
//    fun register(user: User):LiveData<User>{
//        var mLiveData = MutableLiveData<User>()
//
//        UserRepository().register(user).observeForever {
//
//            if (it.username.isNotEmpty())
//                mLiveData.postValue(true)
//            else
//                mLiveData.postValue(false)
//        }
//        return mLiveData
//    }
}
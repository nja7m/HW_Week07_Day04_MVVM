package com.twq.w7_day4_mvvm.view.registeration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.w7_day4_mvvm.repository.UserRepository

class RegisterViewModel: ViewModel() {

	fun register(username:String,password:String,email: String,photo:String): LiveData<Boolean> {
		var mLiveData= MutableLiveData<Boolean>()

		UserRepository().register(username, password, email, photo).observeForever {
			if(it.username.isNotEmpty())
				mLiveData.postValue(true)
			else
				mLiveData.postValue(false)
		}


		return  mLiveData
	}

}
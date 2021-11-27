package com.twq.w7_day4_mvvm.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.repository.UserRepository

class MainViewModel: ViewModel() {

	fun users(): LiveData<List<User>> {
		var mLiveData= MutableLiveData<List<User>>()

		UserRepository().users().observeForever {

			if(it.isNotEmpty())
				mLiveData.postValue(it)
			else
				mLiveData.postValue(listOf())

		}


		return  mLiveData
	}
}
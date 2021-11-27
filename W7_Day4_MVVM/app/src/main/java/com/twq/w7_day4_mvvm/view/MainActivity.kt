package com.twq.w7_day4_mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.databinding.ActivityMainBinding
import com.twq.w7_day4_mvvm.view.home.MainViewModel
import com.twq.w7_day4_mvvm.view.home.UsersAdapter
import com.twq.w7_day4_mvvm.view.profile.ProfileActivity
import com.twq.w7_day4_mvvm.view.registeration.RegisterViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)

        val vm: MainViewModel by viewModels()
        binding.mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        vm.users().observe(this,{
                Log.d("MainActivity", it.toString())
            if (it.isNotEmpty()){
                binding.mRecyclerView.adapter = UsersAdapter(it)
            }
        })

        setContentView(binding.root)
    }
}
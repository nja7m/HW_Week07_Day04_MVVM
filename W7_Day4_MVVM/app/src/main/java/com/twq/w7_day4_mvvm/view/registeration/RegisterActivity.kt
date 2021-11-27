package com.twq.w7_day4_mvvm.view.registeration

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.twq.w7_day4_mvvm.databinding.ActivityRegisterBinding
import com.twq.w7_day4_mvvm.view.home.HomeActivity
import com.twq.w7_day4_mvvm.view.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding = ActivityRegisterBinding.inflate(layoutInflater)

		val vm: RegisterViewModel by viewModels()

		binding.buttonRegister.setOnClickListener {

			vm.register(
				binding.tinputUsername.text.toString(),
				binding.textInputPassword.text.toString(),
				binding.textInputEmail.text.toString(),
				binding.textInputPhoto.text.toString()
			).observe(this,{
				if (it){
					startActivity(Intent(this,HomeActivity::class.java))
				}
			})
		}

		binding.textViewLogin.setOnClickListener {
			var i =Intent(this, LoginActivity::class.java)
			startActivity(i)
		}

		setContentView(binding.root)
	}

}
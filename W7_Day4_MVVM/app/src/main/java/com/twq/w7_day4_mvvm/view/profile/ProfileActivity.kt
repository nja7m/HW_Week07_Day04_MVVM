package com.twq.w7_day4_mvvm.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.databinding.ActivityProfileBinding
import com.twq.w7_day4_mvvm.model.User

class ProfileActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		var binding = ActivityProfileBinding.inflate(layoutInflater)

		var user = intent.getSerializableExtra("user") as User
		binding.userEmailTextView.text = user.email
		binding.userIdTextView.text = user.id
		binding.userNameTextView.text = user.username
		Picasso.get().load(user.photo).into(binding.userPhotoImageView)

		setContentView(binding.root)
	}
}
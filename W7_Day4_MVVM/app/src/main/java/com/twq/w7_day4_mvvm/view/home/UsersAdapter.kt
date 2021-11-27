package com.twq.w7_day4_mvvm.view.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.twq.w7_day4_mvvm.R
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.view.profile.ProfileActivity

class UsersAdapter (var list: List<User>): RecyclerView.Adapter<UserViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
		var v=LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
		return UserViewHolder(v)
	}

	override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
		holder.emailTextView.text=list[position].email
		holder.usernameTextView.text=list[position].username

		if (list[position].photo.isNotEmpty()){
			Picasso.get().load(list[position].photo).into(holder.photoImageView)

		}

		holder.itemView.setOnClickListener {
			var i = Intent(holder.itemView.context, ProfileActivity::class.java)
			i.putExtra("user", list[position])
			holder.itemView.context.startActivity(i)
		}
	}

	override fun getItemCount(): Int {
		return list.size
	}
}

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
	var photoImageView = itemView.findViewById<ImageView>(R.id.photoImageView)
	var usernameTextView = itemView.findViewById<TextView>(R.id.usernameTextView)
	var emailTextView = itemView.findViewById<TextView>(R.id.emailTextView)
}
package com.lapvt.myapplication.btvn_b8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class UserAdapter(private val userList: ArrayList<UserData>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var onItemClick: ((UserData) -> Unit)? = null
    var onBinClick: ((UserData) -> Unit)? = null
    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val ivUser: ImageView = itemView.findViewById(R.id.ivUser)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
        private val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
        val ivBin: ImageView = itemView.findViewById(R.id.ivBin)
        fun setData(user: UserData) {
            ivUser.setImageResource(R.drawable.ic_user)
            tvName.text = user.name
            tvAddress.text = user.address
            tvPhone.text = user.phone
            ivBin.setImageResource(R.drawable.ic_bin)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }
    override fun getItemCount(): Int {
        return if (userList.isNotEmpty()) userList.size else 0
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setData(userList[position])
        holder.ivBin.setOnClickListener {
            onBinClick?.invoke(userList[position])
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(userList[position])
        }
    }
}
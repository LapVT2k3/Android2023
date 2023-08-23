package com.lapvt.myapplication.btvn_b5.bai2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class PersonAdapter(private val personList: List<PersonData>): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.setData(personList[position])
    }

    class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imvAvatar: ImageView = itemView.findViewById(R.id.imvAvatar)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvMessage: TextView = itemView.findViewById(R.id.tvMessage)

        public fun setData(person: PersonData) {
            imvAvatar.setImageBitmap(person.bitmap)
            tvName.text = person.name
            tvMessage.text = person.message
        }
    }
}
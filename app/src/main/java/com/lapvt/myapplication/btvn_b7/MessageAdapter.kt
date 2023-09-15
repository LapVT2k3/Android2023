package com.lapvt.myapplication.btvn_b7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class MessageAdapter(private val messageList: ArrayList<MessageData>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    var onClickItem: ((MessageData) -> Unit)? = null

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivMessage: ImageView = itemView.findViewById(R.id.ivMessage)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvContent: TextView = itemView.findViewById(R.id.tvContent)

        fun setData(message: MessageData) {
            ivMessage.setImageResource(message.image)
            tvTitle.text = message.title
            tvContent.text = message.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (messageList.isNotEmpty()) messageList.size else 0
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.setData(messageList[position])
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(messageList[position])
        }
    }
}
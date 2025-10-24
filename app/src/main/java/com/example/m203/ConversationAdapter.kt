package com.example.m203

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m203.databinding.ConversationItemBinding

class ConversationAdapter(
    conversations: List<Conversation>
) : RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.conversation_item, parent, false)
        return ConversationViewHolder(view)
    }
    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        holder.bind(conversations[position])
    }
    override fun getItemCount(): Int = conversations.size

    inner class ConversationViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding = ConversationItemBinding.bind(itemView)
        fun bind(conversation: Conversation) {
            // Bind conversation data to UI elements
            binding.profileImage.setImageResource(conversation.profileImage)
            binding.name.text = conversation.name
            binding.message.text = conversation.lastMessage
            binding.time.text = conversation.hour
            binding.isOnline.visibility = if (conversation.isOnline) View.VISIBLE else View.GONE

        }
    }

}
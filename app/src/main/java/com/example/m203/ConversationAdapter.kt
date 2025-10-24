package com.example.m203

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ConversationAdapter(
    context: Context,
    conversations: List<Conversation>
) : ArrayAdapter<Conversation>(context, 0, conversations) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: View.inflate(context, R.layout.conversation_item, null)
        val conversation = conversations[position]

        val profileImage = view.findViewById<ImageView>(R.id.profileImage)
        val name = view.findViewById<TextView>(R.id.name)
        val hour = view.findViewById<TextView>(R.id.time)
        val lastMessage = view.findViewById<TextView>(R.id.message)
        val isOnline = view.findViewById<View>(R.id.isOnline)

        profileImage.setImageResource(conversation.profileImage)
        name.text = conversation.name
        hour.text = conversation.hour
        lastMessage.text = conversation.lastMessage
        isOnline.visibility = if (conversation.isOnline) View.VISIBLE else View.GONE

        return view
    }
}
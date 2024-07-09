package com.rajeev.videoplayer.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rajeev.videoplayer.R
import com.rajeev.videoplayer.VideoPlayerActivity
import com.rajeev.videoplayer.dataClass.LiveClassDataClass

class CompletedClassFragmentAdapter(private val mList: List<LiveClassDataClass>):
    RecyclerView.Adapter<CompletedClassFragmentAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CompletedClassFragmentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_class_card, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(androidx.core.R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val card: CardView = itemView.findViewById(R.id.card)
    }

    override fun onBindViewHolder(holder: CompletedClassFragmentAdapter.ViewHolder, position: Int) {
        val liveClassDataClass = mList[position]
        holder.title.text = liveClassDataClass.title
        holder.description.text = liveClassDataClass.description
        holder.card.setOnClickListener{
            val intent = Intent(it.context,VideoPlayerActivity::class.java)
            intent.putExtra("data",liveClassDataClass.link)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}
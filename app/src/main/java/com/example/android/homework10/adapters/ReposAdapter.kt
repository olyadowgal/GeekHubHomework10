package com.example.android.homework10.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.homework10.R
import com.example.android.homework10.userList

class ReposAdapter(private val callback: Callback) : androidx.recyclerview.widget.RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    private val reposList = userList.toMutableList()

    interface Callback {
        fun onUserClicked(position: Int)
    }


    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.onBind(reposList[position])
    }

    override fun getItemCount(): Int {
        return reposList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ReposViewHolder {
        return ReposViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.repos_item,
                parent,
                false
            )
        )
    }

    inner class ReposViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            callback.onUserClicked(adapterPosition)
        }

        private val itemText: TextView = view.findViewById(R.id.item_text)

        fun onBind(item: String) {
            itemText.text = item
        }
    }
}
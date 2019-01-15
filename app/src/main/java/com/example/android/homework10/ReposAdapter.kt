package com.example.android.homework10

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.homework10.repos.GitHubRepository

class ReposAdapter(val repList : List<GitHubRepository>) : RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    private val reposList: MutableList<GitHubRepository> = repList.toMutableList()

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.onBind(reposList[position].name)
    }

    override fun getItemCount(): Int {
        return reposList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ReposAdapter.ReposViewHolder {
        return ReposViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.repos_item,
                parent,
                false
            )
        )
    }

    inner class ReposViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val itemText: TextView = view.findViewById(R.id.item_text)

        fun onBind(item: String) {
            itemText.text = item
        }
    }
}
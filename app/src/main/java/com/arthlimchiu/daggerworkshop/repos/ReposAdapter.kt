package com.arthlimchiu.daggerworkshop.repos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arthlimchiu.daggerworkshop.R

class ReposAdapter(private var repos: List<Repo>) :
    RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)

        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    fun updateRepos(repos: List<Repo>) {
        this.repos = repos
        notifyDataSetChanged()
    }

    inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.repo_name)

        fun bind(repo: Repo) {
            name.text = repo.name
        }
    }
}
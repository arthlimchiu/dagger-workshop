package com.arthlimchiu.daggerworkshop.repos


interface ReposRepository {

    fun getRepos(username: String, onSuccess: (repos: List<Repo>) -> Unit, onFailure: (t: Throwable) -> Unit)
}
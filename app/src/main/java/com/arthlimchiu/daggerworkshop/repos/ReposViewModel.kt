package com.arthlimchiu.daggerworkshop.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReposViewModel(private val reposRepository: ReposRepository) : ViewModel() {

    private val _repos = MutableLiveData<List<Repo>>()

    val repos: LiveData<List<Repo>>
        get() = _repos

    fun getRepos(username: String) {
        reposRepository.getRepos(
            username,
            { repositories -> _repos.value = repositories },
            { t -> Log.e("ReposViewModel", "onFailure: ", t) }
        )
    }
}
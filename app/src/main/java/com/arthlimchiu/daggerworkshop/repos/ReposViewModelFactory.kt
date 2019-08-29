package com.arthlimchiu.daggerworkshop.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ReposViewModelFactory(private val reposRepository: ReposRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)) {
            return ReposViewModel(reposRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel clas")
    }
}
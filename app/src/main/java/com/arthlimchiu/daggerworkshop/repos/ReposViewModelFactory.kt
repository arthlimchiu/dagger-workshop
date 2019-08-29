package com.arthlimchiu.daggerworkshop.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ReposViewModelFactory @Inject constructor(private val reposRepository: ReposRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)) {
            return ReposViewModel(reposRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel clas")
    }
}
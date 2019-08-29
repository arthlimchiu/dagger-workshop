package com.arthlimchiu.daggerworkshop.userdetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserDetailsViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    fun searchUser(username: String) {
        userRepository.getUser(
            username,
            { user -> _user.value = user },
            { t -> Log.e("UserDetailsViewModel", "onFailure: ", t) }
        )
    }
}
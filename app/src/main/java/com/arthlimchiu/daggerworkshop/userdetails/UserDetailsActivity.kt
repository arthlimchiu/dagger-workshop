package com.arthlimchiu.daggerworkshop.userdetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserDetailsActivity : AppCompatActivity() {

    lateinit var factory: UserDetailsViewModelFactory
    private lateinit var viewModel: UserDetailsViewModel

    private lateinit var retrofit: Retrofit
    private lateinit var api: Api

    private lateinit var userRepository: UserRepository

    private lateinit var fullName: TextView
    private lateinit var numOfRepos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        fullName = findViewById(R.id.full_name)
        numOfRepos = findViewById(R.id.num_of_repos)

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)

        userRepository = UserRepositoryImpl(api)

        factory = UserDetailsViewModelFactory(userRepository)

        viewModel = ViewModelProviders.of(this, factory).get(UserDetailsViewModel::class.java)

        viewModel.user.observe(this, Observer { user ->
            fullName.text = user.name
            numOfRepos.text = "Public Repos: ${user.repos}"
        })

        val username = intent.getStringExtra("username")
        viewModel.searchUser(username)
    }
}

package com.arthlimchiu.daggerworkshop.repos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReposActivity : AppCompatActivity() {

    lateinit var factory: ReposViewModelFactory
    private lateinit var viewModel: ReposViewModel

    private lateinit var retrofit: Retrofit
    private lateinit var api: Api

    private lateinit var reposRepository: ReposRepository

    private lateinit var repos: RecyclerView
    private lateinit var reposAdapter: ReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)

        repos = findViewById(R.id.repos)
        repos.layoutManager = LinearLayoutManager(this)
        reposAdapter = ReposAdapter(listOf())
        repos.adapter = reposAdapter

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)

        reposRepository = ReposRepositoryImpl(api)

        factory = ReposViewModelFactory(reposRepository)

        viewModel = ViewModelProviders.of(this, factory).get(ReposViewModel::class.java)

        viewModel.repos.observe(this, Observer { repositories ->
            reposAdapter.updateRepos(repositories)
        })

        val username = intent.getStringExtra("username")
        viewModel.getRepos(username)
    }
}

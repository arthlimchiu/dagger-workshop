package com.arthlimchiu.daggerworkshop.repos

import com.arthlimchiu.daggerworkshop.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposRepositoryImpl(private val api: Api) : ReposRepository {

    override fun getRepos(
        username: String,
        onSuccess: (repos: List<Repo>) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        api.getRepos(username).enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                response.body()?.let { repositories ->
                    onSuccess.invoke(repositories)
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                onFailure.invoke(t)
            }
        })
    }
}
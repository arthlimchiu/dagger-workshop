package com.arthlimchiu.daggerworkshop.repos

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("name") val name: String
)
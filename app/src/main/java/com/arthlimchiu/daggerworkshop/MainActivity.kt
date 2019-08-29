package com.arthlimchiu.daggerworkshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.arthlimchiu.daggerworkshop.repos.ReposActivity
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var search: Button
    private lateinit var viewRepositories: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        search = findViewById(R.id.search)
        viewRepositories = findViewById(R.id.view_repos)
    }

    override fun onStart() {
        super.onStart()

        search.setOnClickListener {
            val intent = Intent(this, UserDetailsActivity::class.java)
            intent.putExtra("username", username.text.toString())
            startActivity(intent)
        }

        viewRepositories.setOnClickListener {
            val intent = Intent(this, ReposActivity::class.java)
            intent.putExtra("username", username.text.toString())
            startActivity(intent)
        }
    }
}

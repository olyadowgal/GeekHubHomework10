package com.example.android.homework10.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.homework10.R
import com.example.android.homework10.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repos_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        repos_list.adapter = viewModel.reposAdapter

        viewModel.clickLiveEvent.observe(this, Observer {
            val intent = Intent(this@MainActivity, UserActivity::class.java)
            intent.putExtra("POSITION", it)
            startActivity(intent)
        })

    }
}
package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        dbHelper = DatabaseHelper(this)

        recyclerView = findViewById(R.id.moviesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddMovie).setOnClickListener {
            startActivity(Intent(this, MovieAddEditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter = MoviesAdapter(dbHelper.getAllMovies())
    }
}

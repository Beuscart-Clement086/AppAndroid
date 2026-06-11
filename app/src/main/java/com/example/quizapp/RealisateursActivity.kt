package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RealisateursActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realisateurs)

        dbHelper = DatabaseHelper(this)

        recyclerView = findViewById(R.id.realisateursRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddRealisateur).setOnClickListener {
            startActivity(Intent(this, RealisateurAddEditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter = RealisateurAdapter(dbHelper.getAllDirectors())
    }
}

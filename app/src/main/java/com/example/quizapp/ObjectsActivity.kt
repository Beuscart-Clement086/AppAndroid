package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ObjectsActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objects)

        dbHelper = DatabaseHelper(this)

        recyclerView = findViewById(R.id.objectsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddObject).setOnClickListener {
            startActivity(Intent(this, ObjectAddEditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter = ObjectAdapter(dbHelper.getAllObjects())
    }
}

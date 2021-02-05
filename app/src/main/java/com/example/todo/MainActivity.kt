package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView = findViewById<ListView>(R.id.listView)
        listView.adapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            toDoRepository.getAllToDos()
        )
        var createButton = findViewById<Button>(R.id.createButton)
        createButton.setOnClickListener{
            Log.d("main", "click on createButton")
            startActivity(
                Intent(this, CreateToDoActivity::class.java)
            )
        }
    }
}
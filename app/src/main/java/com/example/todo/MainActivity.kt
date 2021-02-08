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
        val createButton = findViewById<Button>(R.id.createButton)

        listView.adapter = ArrayAdapter<ToDo>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                toDoRepository.getAllToDos()
        )

        listView.setOnItemClickListener{parent, view, position, id ->
            val item = listView.getItemAtPosition(position) as ToDo
            val intent = Intent(this, ViewToDoActivity::class.java).apply {
                putExtra("id", item.id)
            }
            startActivity(intent)
        }

        createButton.setOnClickListener{
            startActivity(
                    Intent(this, CreateToDoActivity::class.java)
            )
        }
    }
    override fun onStart() {
        super.onStart()
        var listView = findViewById<ListView>(R.id.listView)
        (listView.adapter as ArrayAdapter<ToDo>).notifyDataSetChanged()
    }

}
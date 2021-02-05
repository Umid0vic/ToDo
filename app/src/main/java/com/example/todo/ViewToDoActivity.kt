package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ViewToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_to_do)

        val id = intent.getIntExtra("id",0)
        val toDo = toDoRepository.getToDoById(id)
        findViewById<TextView>(R.id.title).apply {
            text = toDo?.title
        }
    }
}
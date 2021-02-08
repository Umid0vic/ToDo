package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class ViewToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_to_do)

        val id = intent.getIntExtra("id",0)
        val updateBtn = findViewById<Button>(R.id.updateButton)
        val deleteBtn = findViewById<Button>(R.id.deleteButton)


        updateBtn.setOnClickListener(){
            val intent = Intent(this, UpdateToDoActivity::class.java).apply {
                putExtra("id", id)
            }
            startActivity(intent)
        }

        deleteBtn.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle(R.string.deleteTitle)
                .setMessage(R.string.message)
                .setPositiveButton(
                    (R.string.accept)
                ) { dialog, whichButton ->
                    toDoRepository.deleteToDoById(id)
                    finish()
                }.setNegativeButton(
                    (R.string.decline)
                ) { dialog, whichButton ->
                }.show()
        }
    }

    override fun onStart() {
        super.onStart()

        val id = intent.getIntExtra("id",0)
        val toDo = toDoRepository.getToDoById(id)

        findViewById<TextView>(R.id.titleText).apply {
            text = toDo?.title
        }

        findViewById<TextView>(R.id.contentText).apply {
            text = toDo?.content
        }
    }
}
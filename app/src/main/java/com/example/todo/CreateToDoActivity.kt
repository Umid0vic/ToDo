package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        val saveButton = findViewById<Button>(R.id.createButton)

        saveButton.setOnClickListener(){
            val title = this.findViewById<EditText>(R.id.editTextTitle).editableText.toString()
            val content = this.findViewById<EditText>(R.id.editTextTitle).editableText.toString()
            val intent = Intent(this, ViewToDoActivity::class.java).apply {
                putExtra("id", toDoRepository.addToDo(title, content))
            }
            startActivity(intent)

        }
    }
}
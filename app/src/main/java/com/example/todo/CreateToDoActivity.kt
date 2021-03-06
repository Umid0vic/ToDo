package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class CreateToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        var titleText = findViewById<EditText>(R.id.titleText)
        var contentText = findViewById<EditText>(R.id.contentText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.isEnabled = false

        var toDoTextWatcher: TextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveButton.isEnabled = titleText.editableText.isNotEmpty() && contentText.editableText.isNotEmpty()
            }
        }

        titleText.addTextChangedListener(toDoTextWatcher)
        contentText.addTextChangedListener(toDoTextWatcher)


        saveButton.setOnClickListener(){
            val title = this.findViewById<EditText>(R.id.titleText).editableText.toString()
            val content = this.findViewById<EditText>(R.id.contentText).editableText.toString()
            val intent = Intent(this, ViewToDoActivity::class.java).apply {
                putExtra("id", toDoRepository.addToDo(title, content))
            }
            startActivity(intent)
            finish()
        }
    }
}
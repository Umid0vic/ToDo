package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UpdateToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_to_do)
        var titleText = findViewById<EditText>(R.id.titleText)
        var contentText = findViewById<EditText>(R.id.contentText)
        val id = intent.getIntExtra("id",0)
        val toDo = toDoRepository.getToDoById(id)
        val saveUpdatedBtn = findViewById<Button>(R.id.saveUpdatedBtn)

        var toDoTextWatcher: TextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveUpdatedBtn.isEnabled = titleText.editableText.isNotEmpty() && contentText.editableText.isNotEmpty()
            }
        }

        titleText.addTextChangedListener(toDoTextWatcher)
        contentText.addTextChangedListener(toDoTextWatcher)

        findViewById<TextView>(R.id.titleText).apply {
            text = toDo?.title
        }
        findViewById<TextView>(R.id.contentText).apply {
            text = toDo?.content
        }



        saveUpdatedBtn.setOnClickListener(){
            val title = this.findViewById<EditText>(R.id.titleText).editableText.toString()
            val content = this.findViewById<EditText>(R.id.contentText).editableText.toString()
            toDoRepository.updateToDoById(id, title, content)
            finish()
        }
    }
}
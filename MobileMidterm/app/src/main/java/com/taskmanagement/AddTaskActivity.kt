package com.taskmanagement

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AddTaskActivity : AppCompatActivity() {

    private val firestore = FirebaseFirestore.getInstance()
    private var isEditMode = false
    private var taskId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val titleEditText: EditText = findViewById(R.id.titleEditText)
        val descriptionEditText: EditText = findViewById(R.id.descriptionEditText)
        val deadlineEditText: EditText = findViewById(R.id.deadlineEditText)
        val categorySpinner: Spinner = findViewById(R.id.categorySpinner)
        val saveButton: Button = findViewById(R.id.saveButton)

        // Set up the category spinner
        val categories = arrayOf("Work", "Personal", "Shopping", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        // Check if the activity is in edit mode
        taskId = intent.getStringExtra("taskId")
        if (taskId != null) {
            isEditMode = true
            val taskTitle = intent.getStringExtra("taskTitle")
            val taskDescription = intent.getStringExtra("taskDescription")
            val taskDeadline = intent.getStringExtra("taskDeadline")
            val taskCategory = intent.getStringExtra("taskCategory")

            // Populate fields with existing task data
            titleEditText.setText(taskTitle)
            descriptionEditText.setText(taskDescription)
            deadlineEditText.setText(taskDeadline)
            categorySpinner.setSelection(categories.indexOf(taskCategory))
            saveButton.text = "Update Task" // Change button text for editing
        }

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val description = descriptionEditText.text.toString().trim()
            val deadline = deadlineEditText.text.toString().trim()
            val selectedCategory = categorySpinner.selectedItem.toString()

            if (title.isNotEmpty()) {
                if (isEditMode && taskId != null) {
                    updateTaskInFirestore(taskId!!, title, description, deadline, selectedCategory)
                } else {
                    val task = Task(
                        title = title,
                        description = description,
                        createdDate = System.currentTimeMillis().toString(),
                        deadline = deadline,
                        category = selectedCategory
                    )
                    saveTaskToFirestore(task)
                }
            } else {
                Toast.makeText(this, "Title is required", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveTaskToFirestore(task: Task) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            task.userId = userId // Set user ID
            firestore.collection("tasks").add(task)
                .addOnSuccessListener {
                    Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show()
                    setResult(RESULT_OK) // Notify the calling activity
                    finish() // Close the activity
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed to add task: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateTaskInFirestore(taskId: String, title: String, description: String, deadline: String, category: String) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            val updatedTask = Task(
                taskId,
                title,
                description,
                userId,
                System.currentTimeMillis().toString(), // Optionally keep or change the created date
                deadline,
                category
            )
            firestore.collection("tasks").document(taskId)
                .set(updatedTask)
                .addOnSuccessListener {
                    Toast.makeText(this, "Task updated", Toast.LENGTH_SHORT).show()
                    setResult(RESULT_OK) // Notify the calling activity
                    finish() // Close the activity
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed to update task: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show()
        }
    }
}
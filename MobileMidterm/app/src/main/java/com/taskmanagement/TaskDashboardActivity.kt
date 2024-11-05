package com.taskmanagement

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TaskDashboardActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val tasks = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_dashboard)

        setupRecyclerView()
        loadTasks()

        val profileButton: ImageButton = findViewById(R.id.profileButton)
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        val addTaskButton: FloatingActionButton = findViewById(R.id.addTaskButton)
        addTaskButton.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, ADD_TASK_REQUEST_CODE)
        }
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(tasks, this::onEditTask, this::onDeleteTask)
        val recyclerView = findViewById<RecyclerView>(R.id.taskRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter
    }

    private fun loadTasks() {
        Log.d("TaskDashboardActivity", "Loading tasks for user: ${auth.currentUser?.uid}")

        val userId = auth.currentUser?.uid
        if (userId == null) {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show()
            return
        }

        firestore.collection("tasks")
            .whereEqualTo("userId", userId)
            .get()
            .addOnSuccessListener { documents ->
                tasks.clear()
                for (document in documents) {
                    val task = document.toObject(Task::class.java)
                    tasks.add(task)
                }
                if (tasks.isEmpty()) {
                    addDefaultTasks() // Add default tasks if none exist
                } else {
                    taskAdapter.notifyDataSetChanged()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to load tasks: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == ADD_TASK_REQUEST_CODE || requestCode == EDIT_TASK_REQUEST_CODE) {
                loadTasks() // Refresh the task list
            }
        }
    }

    private fun onEditTask(task: Task) {
        val intent = Intent(this, AddTaskActivity::class.java).apply {
            putExtra("taskId", task.taskId)
            putExtra("taskTitle", task.title)
            putExtra("taskDescription", task.description)
            putExtra("taskDeadline", task.deadline) // Pass additional fields
            putExtra("taskCategory", task.category)
        }
        startActivityForResult(intent, EDIT_TASK_REQUEST_CODE)
    }

    private fun onDeleteTask(task: Task) {
        firestore.collection("tasks").document(task.taskId)
            .delete()
            .addOnSuccessListener {
                Toast.makeText(this, "Task deleted", Toast.LENGTH_SHORT).show()
                tasks.remove(task)
                taskAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to delete task: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    companion object {
        const val ADD_TASK_REQUEST_CODE = 1
        const val EDIT_TASK_REQUEST_CODE = 2 // Define EDIT_TASK_REQUEST_CODE
    }

    private fun addDefaultTasks() {
        val userId = auth.currentUser?.uid ?: return
        val defaultTasks = listOf(
            Task("task_1", "Default Task 1", "This is a default task", userId),
            Task("task_2", "Default Task 2", "This is another default task", userId)
        )

        val batch = firestore.batch()
        for (task in defaultTasks) {
            val taskRef = firestore.collection("tasks").document(task.taskId)
            batch.set(taskRef, task)
        }

        batch.commit()
            .addOnSuccessListener {
                Toast.makeText(this, "Default tasks added", Toast.LENGTH_SHORT).show()
                loadTasks() // Refresh the task list after adding
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to add default tasks: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
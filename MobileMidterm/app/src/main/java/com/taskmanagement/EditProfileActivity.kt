package com.taskmanagement

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class EditProfileActivity : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editUsername: EditText
    private lateinit var editEmail: EditText
    private lateinit var saveButton: Button

    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val db: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Initialize views
        editName = findViewById(R.id.editName)
        editUsername = findViewById(R.id.editUsername)
        editEmail = findViewById(R.id.editEmail)
        saveButton = findViewById(R.id.saveButton)

        // Load current user data
        loadCurrentUserData()

        // Save button action
        saveButton.setOnClickListener {
            saveProfileUpdates()
        }
    }

    private fun loadCurrentUserData() {
        val user = auth.currentUser
        user?.let {
            db.collection("users").document(it.uid).get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        editName.setText(document.getString("name"))
                        editUsername.setText(document.getString("username"))
                        editEmail.setText(document.getString("email")) // Change if needed
                    } else {
                        showToast("User data not found.")
                    }
                }
                .addOnFailureListener { e ->
                    showToast("Error loading data: ${e.message}")
                }
        }
    }

    private fun saveProfileUpdates() {
        val user = auth.currentUser
        val name = editName.text.toString()
        val username = editUsername.text.toString()
        val email = editEmail.text.toString()

        if (user != null) {
            // Update Firestore document
            db.collection("users").document(user.uid)
                .update("name", name, "username", username, "email", email)
                .addOnSuccessListener {
                    showToast("Profile updated successfully.")
                    finish() // Close the activity
                }
                .addOnFailureListener { e ->
                    showToast("Error updating profile: ${e.message}")
                }
        } else {
            showToast("User not authenticated.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
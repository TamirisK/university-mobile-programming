package com.taskmanagement

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("SignupActivity", "onCreate called")


        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        val signupButton: Button = findViewById(R.id.signup_button)
        val loginRedirectText: TextView = findViewById(R.id.loginRedirectText)

        signupButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.signup_name).text.toString()
            val email = findViewById<EditText>(R.id.signup_email).text.toString()
            val username = findViewById<EditText>(R.id.signup_username).text.toString()
            val password = findViewById<EditText>(R.id.signup_password).text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign up success, navigate to ProfileActivity
                            startActivity(Intent(this, ProfileActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Signup failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        loginRedirectText.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
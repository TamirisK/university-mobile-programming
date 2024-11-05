package com.taskmanagement

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val signupButton = findViewById<Button>(R.id.signup_button)
        val loginButton = findViewById<Button>(R.id.login_button)

        signupButton.setOnClickListener {
            Toast.makeText(this, "Sign Up button clicked", Toast.LENGTH_SHORT).show()
            Log.d("MainActivity", "Sign Up button clicked")
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            Toast.makeText(this, "Login button clicked", Toast.LENGTH_SHORT).show()
            Log.d("MainActivity", "Login button clicked")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}


//        setContent {
//            TaskManagementTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hellooooo $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    TaskManagementTheme {
//        Greeting("Android")
//    }
//}
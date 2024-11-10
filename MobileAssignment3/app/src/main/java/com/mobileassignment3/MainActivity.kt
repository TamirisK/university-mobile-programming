package com.mobileassignment3

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mobileassignment3.exercise1.HelloFragment
import com.mobileassignment3.exercise2.InputFragment
import com.mobileassignment3.exercise2.OutputFragment
import com.mobileassignment3.exercise3.FragmentTransactionFragment
import com.mobileassignment3.exercise4.Exercise4Fragment
import com.mobileassignment3.exercise5.Exercise4FragmentUpdated5
import com.mobileassignment3.exercise6.Exercise4FragmentUpdated6
import com.mobileassignment3.exercise7.Exercise7Fragment
import com.mobileassignment3.exercise8.Exercise8Fragment
import com.mobileassignment3.exercise9.Exercise9Fragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExercise1: Button = findViewById(R.id.btnExercise1)
        val btnExercise2: Button = findViewById(R.id.btnExercise2)
        val btnExercise3: Button = findViewById(R.id.btnExercise3)
        val btnExercise4: Button = findViewById(R.id.btnExercise4)
        val btnExercise5: Button = findViewById(R.id.btnExercise5)
        val btnExercise6: Button = findViewById(R.id.btnExercise6)
        val btnExercise7: Button = findViewById(R.id.btnExercise7)
        val btnExercise8: Button = findViewById(R.id.btnExercise8)
        val btnExercise9: Button = findViewById(R.id.btnExercise9)

        btnExercise1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HelloFragment())
                .addToBackStack(null)
                .commit()
        }

        btnExercise2.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, InputFragment())
                    .add(R.id.fragmentContainer, OutputFragment())
                    .commit()
            }
        }

        btnExercise3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentTransactionFragment())
                .commit()
        }

        btnExercise4.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Exercise4Fragment())
                .addToBackStack(null)
                .commit()
        }

        btnExercise5.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Exercise4FragmentUpdated5())
                .addToBackStack(null)
                .commit()
        }

        btnExercise6.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Exercise4FragmentUpdated6())
                .addToBackStack(null)
                .commit()
        }

        btnExercise7.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Exercise7Fragment())
                .addToBackStack(null)
                .commit()
        }

        btnExercise8.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Exercise8Fragment())
                .addToBackStack(null)
                .commit()
        }

        btnExercise9.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, Exercise9Fragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}
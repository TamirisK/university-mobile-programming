package com.mobileassignment3.exercise1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobileassignment3.R

class HelloFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(this::class.java.simpleName, "onCreateView")
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d(this::class.java.simpleName, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(this::class.java.simpleName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(this::class.java.simpleName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(this::class.java.simpleName, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(this::class.java.simpleName, "onDestroyView")
    }
}
package com.mobileassignment3.exercise2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mobileassignment3.R

class OutputFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_output, container, false)

        val textView: TextView = binding.findViewById(R.id.textViewOutput)

        sharedViewModel.text.observe(viewLifecycleOwner) { newText ->
            textView.text = newText
        }

        return binding
    }
}
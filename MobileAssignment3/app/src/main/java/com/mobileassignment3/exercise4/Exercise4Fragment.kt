package com.mobileassignment3.exercise4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobileassignment3.R

class Exercise4Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise4_activity, container, false)

        val movieList = listOf(
            Movie("Everything Everywhere All at Once", 2023, R.drawable.everything_everywhere_all_at_once),
            Movie("CODA", 2022, R.drawable.coda),
            Movie("Nomadland", 2021, R.drawable.nomadland),
            Movie("Parasite", 2020, R.drawable.parasite),
            Movie("Green Book", 2019, R.drawable.green_book)
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MovieAdapter(movieList)

        return view
    }
}
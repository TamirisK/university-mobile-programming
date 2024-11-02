package com.example.mobiletestapp.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiletestapp.databinding.FragmentSearchBinding
import com.example.mobiletestapp.ui.dashboard.Post
import com.example.mobiletestapp.ui.dashboard.PostAdapter
import com.example.mobiletestapp.ui.posts

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private var filteredPosts: List<Post> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        postAdapter = PostAdapter(posts)
        recyclerView.adapter = postAdapter

        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterPosts(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        return root
    }

    private fun filterPosts(query: String) {
        filteredPosts = if (query.isEmpty()) {
            posts
        } else {
            posts.filter {
                it.username.contains(query, ignoreCase = true) ||
                        it.caption.contains(query, ignoreCase = true)
            }
        }
        postAdapter.updatePosts(filteredPosts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
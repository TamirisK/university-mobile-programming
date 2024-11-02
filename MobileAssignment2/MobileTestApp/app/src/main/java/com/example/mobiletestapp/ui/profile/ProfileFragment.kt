package com.example.mobiletestapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiletestapp.R
import com.example.mobiletestapp.databinding.FragmentProfileBinding
import com.example.mobiletestapp.ui.dashboard.PostAdapter
import com.example.mobiletestapp.ui.posts

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.profileImage.setImageResource(R.drawable.image1)
        binding.username.text = "tamiris"
        binding.bio.text = "tamiris's bio"
        binding.postsCount.text = "Posts: ${posts.count { it.username == "tamiris" }}"

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        val userPosts = posts.filter { it.username == "tamiris" }
        postAdapter = PostAdapter(userPosts)
        recyclerView.adapter = postAdapter

        return root
    }
}
package com.example.mobiletestapp.ui.dashboard

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiletestapp.R

data class Post(
    val imageResId: Int,
    val username: String,
    val caption: String,
    var likesCount: Int = 0
)

interface OnLikeListener {
    fun onPostLiked(post: Post)
}

class PostAdapter(private var posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    @SuppressLint("SetTextI18n")
    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.postImage)
        val usernameTextView: TextView = view.findViewById(R.id.username)
        val captionTextView: TextView = view.findViewById(R.id.postDescription)
        val likesCountTextView: TextView = view.findViewById(R.id.likesCount)
        val likeButton: Button = view.findViewById(R.id.likeButton)

        init {
            likeButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val post = posts[position]
                    post.likesCount++
                    likesCountTextView.text = "${post.likesCount} likes"
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.imageView.setImageResource(post.imageResId)
        holder.usernameTextView.text = post.username
        holder.captionTextView.text = post.caption
        holder.likesCountTextView.text = "${post.likesCount} likes"
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatePosts(newPosts: List<Post>) {
        posts = newPosts
        notifyDataSetChanged()
    }
}
package com.example.mobiletestapp.ui.addpost

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobiletestapp.R
import com.example.mobiletestapp.ui.Notification
import com.example.mobiletestapp.NotificationListener
import com.example.mobiletestapp.ui.dashboard.Post

class AddPostFragment : Fragment() {

    private lateinit var imagePreview: ImageView
    private lateinit var usernameInput: EditText
    private lateinit var imageNameInput: EditText
    private lateinit var captionInput: EditText
    private lateinit var uploadButton: Button

    private val posts = mutableListOf<Post>()
    private val existingUsers = listOf("tamiris", "abildayeva", "kang")

    private lateinit var notificationListener: NotificationListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_addpost, container, false)

        imagePreview = view.findViewById(R.id.imagePreview)
        usernameInput = view.findViewById(R.id.usernameInput)
        imageNameInput = view.findViewById(R.id.imageNameInput)
        captionInput = view.findViewById(R.id.captionInput)
        uploadButton = view.findViewById(R.id.uploadButton)

        imagePreview.setImageResource(R.drawable.image4)

        uploadButton.setOnClickListener { uploadPost() }

        notificationListener = activity as? NotificationListener ?: throw ClassCastException("Activity must implement NotificationListener")

        return view
    }

    private fun uploadPost() {
        Log.d("AddPostFragment", "uploadPost called")

        val username = usernameInput.text.toString()
        val imageName = imageNameInput.text.toString()
        val caption = captionInput.text.toString()

        Log.d("AddPostFragment", "Inputs - Username: $username, ImageName: $imageName, Caption: $caption")

        if (username.isNotEmpty() && imageName.isNotEmpty() && caption.isNotEmpty()) {
            if (existingUsers.contains(username)) {
                val imageResId = getDrawableResourceByName(imageName)
                Log.d("AddPostFragment", "Image Resource ID: $imageResId")

                if (imageResId != null) {
                    val newPost = Post(imageResId, username, caption)
                    posts.add(newPost)

                    val notificationMessage = "$username uploaded a new post: $caption"
                    val notification = Notification(notificationMessage, System.currentTimeMillis())
                    notificationListener.onPostUploaded(notification)
                    Toast.makeText(requireContext(), "Post uploaded: $caption", Toast.LENGTH_SHORT).show()

                    usernameInput.text.clear()
                    imageNameInput.text.clear()
                    captionInput.text.clear()
                } else {
                    Log.e("AddPostFragment", "Image not found: $imageName")
                    Toast.makeText(requireContext(), "Image not found: $imageName", Toast.LENGTH_SHORT).show()
                }
            } else {
                Log.e("AddPostFragment", "User does not exist: $username")
                Toast.makeText(requireContext(), "User does not exist: $username", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("AddPostFragment", "Please fill in all fields")
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDrawableResourceByName(name: String): Int? {
        val resourceId = requireContext().resources.getIdentifier(name, "drawable", requireContext().packageName)
        Log.d("AddPostFragment", "Drawable Resource ID for $name: $resourceId")
        return if (resourceId != 0) resourceId else null
    }
}
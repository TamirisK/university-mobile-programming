package com.taskmanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class TaskAdapter(
    private var tasks: List<Task>,
    private val onEdit: (Task) -> Unit,
    private val onDelete: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskTitle: TextView = itemView.findViewById(R.id.taskTitle)
        private val taskCreatedDate: TextView = itemView.findViewById(R.id.taskCreatedDate) // Ensure you add this to item_task.xml
        private val taskDeadline: TextView = itemView.findViewById(R.id.taskDeadline) // Ensure you add this to item_task.xml
        private val editTaskButton: MaterialButton = itemView.findViewById(R.id.editTaskButton)
        private val deleteTaskButton: MaterialButton = itemView.findViewById(R.id.deleteTaskButton)

        fun bind(task: Task) {
            taskTitle.text = task.title
            taskCreatedDate.text = task.createdDate // Ensure Task has createdDate property
            taskDeadline.text = task.deadline // Ensure Task has deadline property

            editTaskButton.setOnClickListener { onEdit(task) }
            deleteTaskButton.setOnClickListener { onDelete(task) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}
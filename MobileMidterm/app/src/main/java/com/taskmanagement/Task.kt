package com.taskmanagement

data class Task(
    var title: String = "",
    var description: String = "",
    var createdDate: String = "",
    var deadline: String = "",
    var userId: String = "",
    var taskId: String = "",
    var category: String = "" // Added category field
)



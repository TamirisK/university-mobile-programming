package com.week2

class Course(
    var courseId: Int,
    var courseName: String,
    var credits: Int
){

    fun addStudent(student: Student){
        println("${student.name} added to the course $courseName as student")
    }

    fun addTeacher(teacher: Teacher){
        println("${teacher.name} added to the course $courseName as teacher")
    }

    override fun toString(): String{
        // fun getInfo(): String{
        return "Id: $courseId, Name: $courseName, Credits: $credits"
    }
}
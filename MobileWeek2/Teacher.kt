package com.week2


class Teacher(
    name: String,
    surname: String,
    age: Int,

    var id: Int,
    var academicDegree: String,
    var email: String
) : Person(name, surname, age){


    override fun toString(): String{
        // fun getInfo(): String{
        return "Id: $id, Name: $name, Academic Degree: $academicDegree, Email: $email"
    }

    fun addTeacherToCourse(course: Course){
        println("$name $surname added to the course ${course.courseName}")
    }
}
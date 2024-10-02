package com.week2

fun main() {
    val name = "Kotlin"
    println("Hello, " + name + "!")
    var student = Student("Kamila", "Kim", 20, 111111, 1, "SE")
    var teacher = Teacher("Adam", "Lee", 30, 22222, "Senior-Lector", "a.lee@gmail.com")

    println(student.toString())
    println(teacher.toString())
}
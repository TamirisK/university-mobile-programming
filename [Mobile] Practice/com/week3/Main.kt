package com.week3

import com.week2.Course
import com.week2.Student
import com.week2.Teacher

fun main(){
//    Example of list
    println("\tExample of list")
    val students = listOf(
        Student("Kamila", "Kim", 19, 111111, 1, "SE"),
        Student("Aidana", "Kim", 22, 111112, 1, "SE"),
        Student("Moldir", "Kim", 20, 111113, 1, "SE")
    )

//    println(students)
//    for (student in students){
//        println(student)
//    }

    for (student in students.sortedBy { it.age }){
        println(student)
    }



//    Example of map
    println("\n\tExample of map")
    val courses = mapOf(
        911111 to Course(911111, "Mobile Programming", 4),
        911112 to Course(911112, "Web Dev App", 6),
        911113 to Course(911113, "OOP", 5)
    )

    println("All keys ${courses.keys}")
    println("All values ${courses.values}")


//    Example of set
    println("\n\tExample of set")
    val teachers = setOf(
        Teacher("Adam", "Lee", 30, 22221, "Senior-Lector", "a.lee@gmail.com"),
        Teacher("Tomas", "Lee", 25, 22222, "Senior-Lector", "t.lee@gmail.com")
    )

//    println(teachers)
    for (teacher in teachers){
        println(teacher)
    }

    teachers.sortedBy { it.age }.forEach { teacher -> println("Names: ${teacher.name}") }
}
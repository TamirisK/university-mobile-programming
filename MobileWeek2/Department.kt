package com.week2

class Department(
    var departmentName: String,
    var head: String,
    var countOfEmployees: Int
){

    override fun toString(): String{
        // fun getInfo(): String{
        return "Department $departmentName has $countOfEmployees employees"
    }

    fun addTeacher(teacher: Teacher){
        println("teacher.name joined to the $departmentName")
    }
}
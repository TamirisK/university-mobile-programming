package com.week3done

class Instructor(
    name: String,
    age: Int,
    email: String,

    private var employeeId: String,
    private var department: String
) : Person(name, age, email) {

    fun getEmployeeID(): String{
        return employeeId
    }

    fun getEmployeeID(employeeId: String){
        this.employeeId = employeeId
    }

    fun getDepartment(): String{
        return department
    }

    fun setDepartment(department: String){
        this.department = department
    }

    fun teach(course: Course) {
        course.setInstructor(this)
        println("${getName()} is teaching ${course.getCourseName()}.")
    }

    override fun getDetails(): String {
        return super.getDetails() + ", Employee ID: $employeeId, Department: $department"
    }
}
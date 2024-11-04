package com.week3done

class Student(
    name: String,
    age: Int,
    email: String,

    private var studentId: String,
    private var major: String
) : Person(name, age, email) {

    fun getStudentID(): String{
        return studentId
    }

    fun setStudentID(studentId: String){
        this.studentId = studentId
    }

    fun getMajor(): String{
        return major
    }

    fun setMajor(major: String){
        this.major = major
    }

    fun study() {
        println("${getName()} is studying.")
    }

    fun enroll(course: Course) {
        course.addStudent(this)
        println("${getName()} has enrolled in ${course.getCourseName()}")
    }

    override fun getDetails(): String {
        return super.getDetails() + ", Student ID: $studentId, Major: $major"
    }
}
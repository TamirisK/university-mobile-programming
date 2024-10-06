package com.week3done

class Course(
    private var courseName: String,
    private var courseCode: String,
    private var credits: Int
) {
    private var instructor: Instructor? = null
    private val students: MutableList<Student> = mutableListOf()

    fun getCourseName(): String{
        return courseName
    }

    fun setCourseName(courseName: String){
        this.courseName = courseName
    }

    fun getCourseCode(): String{
        return courseCode
    }

    fun setCourseCode(courseCode: String){
        this.courseCode = courseCode
    }

    fun getCredits(): Int{
        return credits
    }

    fun setCredits(credits: Int){
        if (credits > 0){
            this.credits = credits
        } else println("Credits cannot be negative")
    }

    fun setInstructor(instructor: Instructor) {
        this.instructor = instructor
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun courseInfo(): String {
        return "Course: $courseName ($courseCode), Credits: $credits, Instructor: ${instructor?.getName() ?: "TBA"}"
    }

    fun getStudents(): List<Student> = students
}
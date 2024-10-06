package com.week3done

class Department(
    private var name: String,
    private var code: String
) {
    fun getName(): String{
        return name
    }

    fun setName(name: String){
        this.name = name
    }

    fun getCode(): String{
        return code
    }

    fun setCode(code: String){
        this.code = code
    }

    private val courses: MutableList<Course> = mutableListOf()
    private val instructors: MutableList<Instructor> = mutableListOf()

    fun addCourse(course: Course) {
        courses.add(course)
        println("Course ${course.getCourseName()} added to $name department")
    }

    fun addInstructor(instructor: Instructor) {
        instructors.add(instructor)
        println("Instructor ${instructor.getName()} added to $name department")
    }

    fun getCourses(): List<Course> = courses
    fun getInstructors(): List<Instructor> = instructors


    fun printAllCourses() {
        if (courses.isEmpty()) {
            println("No courses available in the $name department")
        } else {
            println("Courses in the $name department:")
            for (course in courses) {
                println("\t${course.courseInfo()}")
            }
        }
    }

    fun printAllInstructors() {
        if (instructors.isEmpty()) {
            println("No instructors available in the $name department")
        } else {
            println("Instructors in the $name department:")
            for (instructor in instructors) {
                println(instructor.getDetails())
            }
        }
    }
}
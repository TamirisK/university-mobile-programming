package com.week3done

class Enrollment {
    private val enrollments: MutableList<Pair<Student, Course>> = mutableListOf()

    fun enrollStudent(student: Student, course: Course) {
        enrollments.add(Pair(student, course))
        course.addStudent(student)
        println("${student.getName()} has been enrolled in ${course.getCourseName()}")
    }

    fun getEnrollments(): List<Pair<Student, Course>> = enrollments

    fun printStudentSchedules(student: Student) {
        println("Scheduled lessons for ${student.getName()}:")
        for ((studentPair, course) in enrollments) {
            if (studentPair == student) {
                println(course.courseInfo())
            }
        }
    }

    fun printInstructorSchedules(instructor: Instructor) {
        println("Scheduled lessons for ${instructor.getName()}:")
        for ((studentPair, course) in enrollments) {
            if (course.getStudents().contains(studentPair)) {
                println(course.courseInfo())
            }
        }
    }
}
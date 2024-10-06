package com.week3done

class PersonUtils {
    fun filterByName(persons: List<Person>, name: String): List<Person> {
        return persons.filter { it.getName().contains(name, ignoreCase = true) }
    }

    fun filterStudentsByMajor(students: List<Student>, major: String): List<Student> {
        return students.filter { it.getMajor().equals(major, ignoreCase = true) }
    }

    fun sortByAge(persons: List<Person>): List<Person> {
        return persons.sortedBy { it.getAge() }
    }

    fun sortStudentsByName(students: List<Student>): List<Student> {
        return students.sortedBy { it.getName() }
    }

    fun searchByEmail(persons: List<Person>, email: String): Person? {
        return persons.find { it.getEmail().equals(email, ignoreCase = true) }
    }

    fun getStudentsInCourse(course: Course): List<Student> {
        return course.getStudents()
    }
}
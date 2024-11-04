package com.week3done

val csDepartment = Department("Computer Science", "CS")
val mathDepartment = Department("Mathematics", "MCM")

val enrollment = Enrollment()
val personUtils = PersonUtils()
val allStudents = mutableListOf<Student>()
val allRooms = mutableListOf<Classroom>()

val classroom1 = Classroom(101, 30)
val classroom2 = Classroom(102, 40)

fun main() {
    val instructor1 = Instructor("Dr. Adam Lee", 40, "a.lee@edu.kz", "EMP111", "Mathematics")
    val instructor2 = Instructor("Dr. Tomas Kang", 30, "t.kang@edu.kz", "EMP112", "Computer Science")

    val student1 = Student("Kamila Kim", 21, "k_kim@edu.kz", "STUD111", "Computer Science")
    val student2 = Student("Aruzhan Kim", 19, "a_kim@edu.kz", "STUD211", "Mathematics")
    val student3 = Student("Moldir Kim", 20, "m_kim@edu.kz", "STUD112", "Computer Science")

    val course1 = Course("Introduction to Kotlin", "CS101", 3)
    val course2 = Course("Mathematics 1", "MATH101", 4)
    val course3 = Course("Mobile Programming", "CS102", 5)


    val schedule1 = Schedule(course1, TimeSlot.TIME_1PM_2PM, Weekday.MONDAY)
    val schedule2 = Schedule(course2, TimeSlot.TIME_11AM_12PM, Weekday.TUESDAY)


//    val persons = listOf(student1, student2, student3, instructor1, instructor2)
//
//    val filteredByName = personUtils.filterByName(persons, "Alice")
//    println("\n\tFiltered by name (Alice): ${filteredByName.map { it.getDetails() }}")
//
//    val filteredByMajor = personUtils.filterStudentsByMajor(listOf(student1, student2, student3), "Computer Science")
//    println("\n\tFiltered students by major (Computer Science): ${filteredByMajor.map { it.getDetails() }}")
//
//    val sortedByAge = personUtils.sortByAge(persons)
//    println("\n\tSorted by age: ${sortedByAge.map { it.getDetails() }}")
//
//    val searchedPerson = personUtils.searchByEmail(persons, "smith@university.edu")
//    println("\n\tSearched by email (smith@university.edu): ${searchedPerson?.getDetails() ?: "Not found"}")
//
//    val studentsInCourse = personUtils.getStudentsInCourse(course1)
//    println("\n\tStudents in ${course1.courseName}: ${studentsInCourse.map { it.getDetails() }}")
//
////    println("-----------------------------------")
////    csDepartment.printAllCourses()
////
////    println("-----------------------------------")
////    classroom1.printScheduledLessons()
////
////    println("-----------------------------------")
////    enrollment.printStudentSchedules(student1)
////
////    println("-----------------------------------")
////    enrollment.printInstructorSchedules(instructor1)


    mathDepartment.addInstructor(instructor1)
    csDepartment.addInstructor(instructor2)

    csDepartment.addCourse(course1)
    mathDepartment.addCourse(course2)
    csDepartment.addCourse(course3)

    allStudents.add(student1)
    allStudents.add(student2)
    allStudents.add(student3)

    enrollment.enrollStudent(student1, course1)
    enrollment.enrollStudent(student2, course2)
    enrollment.enrollStudent(student3, course1)

    classroom1.addSchedule(schedule1)
    classroom2.addSchedule(schedule2)

    allRooms.add(classroom1)
    allRooms.add(classroom2)


    while (true) {
        printMenu()
        when (readLine()?.toIntOrNull()) {
            1 -> addInstructor()
            2 -> addStudent()
            3 -> addCourse()
            4 -> addRoom()
            5 -> addSchedule()
            6 -> enrollStudent()
            7 -> enrollInstructor()
            8 -> showRooms()
            9 -> showInstructors()
            10 -> showStudents()
            11 -> showCourses()
            12 -> filterByMajor()
            13 -> searchByNameOrID()
            14 -> showStudentsInCourse()
            15 -> sortStudentsByNameInCourse()
            16 -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid value, please try again")
        }
    }
}

// ---------------------------DONE---------------------------------
fun printMenu(){
    println("\n+-------------------------------------------------------+")
    println("| Menu:                                                 |")
    println("+-------------------------------------------------------+")
    println("| 1. Add Instructor                                     |")
    println("| 2. Add Student                                        |")
    println("| 3. Add Course                                         |")

    println("| 4. Add Room to Course                                 |")
    println("| 5. Add Schedule                                       |")

    println("| 6. Enroll Student to Course                           |")
    println("| 7. Enroll Instructor to Course                        |")

    println("| 8. Show All Rooms                                     |")
    println("| 9. Show All Instructors                               |")
    println("| 10. Show All Students                                  |")
    println("| 11. Show All Courses                                  |")

    println("| 12. Filter Students by Major                          |")
    println("| 13. Search Student by Name or ID                      |")
    println("| 14. Show Students in a Course by Course ID            |")
    println("| 15. Show Students sorted by Name                      |")

    println("| 16. Exit                                              |")
    println("+-------------------------------------------------------+")

    print("Choose an option: ")
}

// ---------------------------DONE---------------------------------
fun addInstructor(){
    print("\nEnter instructor name: ")
    val name = readLine()!!
    print("Enter instructor age: ")
    val age = readLine()!!.toInt()
    print("Enter instructor email: ")
    val email = readLine()!!
    print("Enter instructor employee ID: ")
    val employeeId = readLine()!!
    print("Enter instructor department: ")
    val department = readLine()!!

    val instructor = Instructor(name, age, email, employeeId, department)
    if (department.equals("Computer Science", ignoreCase = true)) {
        csDepartment.addInstructor(instructor)
    } else if (department.equals("Mathematics", ignoreCase = true)) {
        mathDepartment.addInstructor(instructor)
    } else {
        println("Error! Department not found!")
    }
}

// ---------------------------DONE---------------------------------
fun addStudent(){
    print("\nEnter student name: ")
    val name = readLine()!!
    print("Enter student age: ")
    val age = readLine()!!.toInt()
    print("Enter student email: ")
    val email = readLine()!!
    print("Enter student ID: ")
    val studentId = readLine()!!
    print("Enter student major: ")
    val major = readLine()!!

    val student = Student(name, age, email, studentId, major)
    allStudents.add(student)
    println("Student $name added")
}

// ---------------------------DONE---------------------------------
fun addCourse(){
    print("Enter course name: ")
    val courseName = readLine()!!
    print("Enter course code: ")
    val courseCode = readLine()!!
    print("Enter course credits: ")
    val credits = readLine()!!.toInt()

    val course = Course(courseName, courseCode, credits)
    if (courseCode.contains("CS", ignoreCase = true)) {
        csDepartment.addCourse(course)
    } else if (courseCode.contains("MATH", ignoreCase = true)) {
        mathDepartment.addCourse(course)
    }
}

// ------------------------------------------------------------
fun addRoom(){
    print("\nEnter course name: ")
    val courseName = readLine()!!

    val course = csDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }
        ?: mathDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }

    if (course != null) {
        print("Enter student email: ")
        val studentEmail = readLine()!!
        val student = allStudents.find { it.getEmail().equals(studentEmail, ignoreCase = true) }

        print("Enter instructor email: ")
        val instructorEmail = readLine()!!
        val instructor = allStudents.find { it.getEmail().equals(instructorEmail, ignoreCase = true) } as? Instructor

        if (student != null && instructor != null) {
            val schedule = classroom1.getSchedules().firstOrNull()
            if (schedule != null) {
                println(schedule.getDetailedInfo(student, instructor))
            } else {
                println("No schedules found for the selected course.")
            }
        } else {
            println("Error! Student or Instructor not found!")
        }
    } else {
        println("Error! Course not found!")
    }
}

// ---------------------------DONE---------------------------------
fun addSchedule(){
    print("\nEnter Course name or Course ID to create schedule: ")
    val courseName = readLine()!!
    val course = csDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }
        ?: mathDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }
    val courseID = csDepartment.getCourses().find { it.getCourseCode().equals(courseName, ignoreCase = true) }
        ?: mathDepartment.getCourses().find { it.getCourseCode().equals(courseName, ignoreCase = true) }

    if (course != null) {
        val selectedTimeSlot = chooseTimeSlot()
        val selectedWeekday = chooseWeekday()

        println("Select a room number:")
        allRooms.forEachIndexed { index, roomNumber ->
            println("${index + 1}. ${roomNumber.getRoomNumber()}")
        }

        var choice: Int
        do {
            print("Enter the number corresponding to your choice: ")
            choice = readLine()?.toIntOrNull() ?: 0
        } while (choice < 1 || choice > allRooms.size)

        var selectedRoom = allRooms[choice-1]

        if (isClassroomAvailable(selectedRoom, selectedTimeSlot, selectedWeekday)){
            val scheduleExample = Schedule(course, selectedTimeSlot, selectedWeekday)
            selectedRoom.addSchedule(scheduleExample)
            println("Course $courseName added at $selectedTimeSlot on $selectedWeekday Room №${selectedRoom.getRoomNumber()}")
        } else
            println("Error! Selected room ${selectedRoom.getRoomNumber()} is not available at $selectedTimeSlot on $selectedWeekday")

    } else if (courseID != null) {
        val selectedTimeSlot = chooseTimeSlot()
        val selectedWeekday = chooseWeekday()

        println("Select a room number:")
        allRooms.forEachIndexed { index, roomNumber ->
            println("${index + 1}. ${roomNumber.getRoomNumber()}")
        }

        var choice: Int
        do {
            print("Enter the number corresponding to your choice: ")
            choice = readLine()?.toIntOrNull() ?: 0
        } while (choice < 1 || choice > allRooms.size)

        var selectedRoom = allRooms[choice-1]


        println("Selected classroom ${selectedRoom.getRoomNumber()}")

        if (isClassroomAvailable(selectedRoom, selectedTimeSlot, selectedWeekday)){
            val scheduleExample = Schedule(courseID, selectedTimeSlot, selectedWeekday)
            selectedRoom.addSchedule(scheduleExample)
            println("Course $courseName added at $selectedTimeSlot on $selectedWeekday Room №${selectedRoom.getRoomNumber()}")
        } else
            println("Error! Selected room ${selectedRoom.getRoomNumber()} is not available at $selectedTimeSlot on $selectedWeekday")

    } else {
        println("Course not found!")
    }
}

fun chooseTimeSlot(): TimeSlot {
    println("Select a time slot:")
    TimeSlot.values().forEachIndexed { index, timeSlot ->
        println("${index + 1}. ${timeSlot.name}")
    }

    var choice: Int
    do {
        print("Enter the number corresponding to your choice: ")
        choice = readLine()?.toIntOrNull() ?: 0
    } while (choice < 1 || choice > TimeSlot.values().size)

    return TimeSlot.values()[choice - 1]
}

fun chooseWeekday(): Weekday {
    println("Select a weekday:")
    Weekday.values().forEachIndexed { index, weekday ->
        println("${index + 1}. ${weekday.name}")
    }

    var choice: Int
    do {
        print("Enter the number corresponding to your choice: ")
        choice = readLine()?.toIntOrNull() ?: 0
    } while (choice < 1 || choice > Weekday.values().size)

    return Weekday.values()[choice - 1]
}

fun isClassroomAvailable(classroom: Classroom, timeSlot: TimeSlot, weekday: Weekday): Boolean{
    return classroom.getSchedules().none { schedule ->
        schedule.getDay() == weekday && schedule.getTime() == timeSlot
    }
}


// ---------------------------DONE---------------------------------
fun enrollStudent(){
    print("\nEnter student email to enroll: ")
    val studentEmail = readLine()!!
    val student = allStudents.find { it.getEmail().equals(studentEmail, ignoreCase = true) }
    if (student != null) {
        print("Enter course name to enroll in: ")
        val courseName = readLine()!!
        val course = csDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }
            ?: mathDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }

        if (course != null) {
            enrollment.enrollStudent(student, course)
        } else {
            println("Error! Course not found!")
        }
    } else {
        println("Error! Student not found!")
    }
}

// ------------------------------------------------------------
fun enrollInstructor(){
    print("\nEnter instructor email to enroll: ")
}

// ---------------------------DONE---------------------------------
fun showRooms(): String {
    return allRooms.joinToString(separator = "\n", prefix = "All Rooms:\n") { it.printScheduledLessons().toString() }
}

// ---------------------------DONE---------------------------------
fun showInstructors(){
    println("\nAll Instructors: ")
    csDepartment.getInstructors().forEach { println("\t${it.getDetails()}") }
    mathDepartment.getInstructors().forEach { println("\t${it.getDetails()}") }
}

// ---------------------------DONE---------------------------------
fun showStudents(){
    println("\nAll Students:")
    allStudents.forEach {
        println(it.getDetails())
    }
}

// ---------------------------DONE---------------------------------
fun showCourses(){
    println("\nAll Courses:")
    csDepartment.printAllCourses()
    mathDepartment.printAllCourses()
}

// ---------------------------DONE---------------------------------
fun filterByMajor(){
    print("\nEnter major to filter: ")
    val major = readLine()!!
    val filteredStudents = personUtils.filterStudentsByMajor(allStudents, major)
    println("Filtered students by major ($major): ${filteredStudents.map { it.getDetails() }}")
}

// ---------------------------DONE---------------------------------
// can add Instructors
fun searchByNameOrID(){
    print("\nEnter Student name or ID to search: \n")
    val input = readLine()!!
    val searchStudent = allStudents.find {
        it.getName().equals(input, ignoreCase = true) ||
                it.getStudentID().equals(input, ignoreCase = true)
    }

//    csDepartment.getInstructors().find { it.getName().equals(input, ignoreCase = true) ||
//            it.getEmployeeID().equals(input, ignoreCase = true) }
//    mathDepartment.getInstructors().find { it.getName().equals(input, ignoreCase = true) ||
//            it.getEmployeeID().equals(input, ignoreCase = true) }

    println("Searched for '$input': ${searchStudent?.getDetails() ?: "Not found"}")
}

// ---------------------------DONE---------------------------------
fun showStudentsInCourse(){
    print("\nEnter Course name or Course ID to show students: ")
    val courseName = readLine()!!
    val course = csDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }
        ?: mathDepartment.getCourses().find { it.getCourseName().equals(courseName, ignoreCase = true) }
    val courseID = csDepartment.getCourses().find { it.getCourseCode().equals(courseName, ignoreCase = true) }
        ?: mathDepartment.getCourses().find { it.getCourseCode().equals(courseName, ignoreCase = true) }

    if (course != null) {
        val studentsInCourse = personUtils.getStudentsInCourse(course)
//        println("Students in ${course.getCourseName()}: ${studentsInCourse.map { it.getDetails() }}")
        println("Students in ${course.getCourseName()}: ")
        for (student in studentsInCourse) {
            println("\t" + student.getDetails())
        }
    } else if (courseID != null) {
        val studentsInCourse = personUtils.getStudentsInCourse(courseID)
//        println("Students in ${courseID.getCourseName()}: ${studentsInCourse.map { it.getDetails() }}")
        println("Students in ${courseID.getCourseName()}: ")
        for (student in studentsInCourse) {
            println("\t" + student.getDetails())
        }
    } else {
        println("Course not found!")
    }
}

// ---------------------------DONE---------------------------------
fun sortStudentsByNameInCourse(){
    println("\nAll sorted students: ")
    for (student in personUtils.sortStudentsByName(allStudents)) {
        println("\t" + student.getDetails())
    }
}
package com.week3done

class Schedule(
    var course: Course,
//    var classroom: Classroom,
    private var time: TimeSlot,
    private var day: Weekday
) {
    fun getTime(): TimeSlot {
        return time
    }

    fun setTime(time: TimeSlot) {
        this.time = time
    }

    fun getDay(): Weekday {
        return day
    }

    fun setDay(day: Weekday) {
        this.day = day
    }

    fun getScheduleInfo(): String {
        return "\t${day.name} ${time.display}: ${course.getCourseName()}"
    }

    fun changeTime(newTime: TimeSlot) {
        println("Changing schedule time from ${time.display} to ${newTime.display}")
        time = newTime
    }

    fun getDetailedInfo(student: Student, instructor: Instructor): String {
        return "" +
                "Course: ${course.getCourseName()}, " +
                "Schedule: ${getScheduleInfo()}, " +
                "Student: ${student.getDetails()}, " +
                "Instructor: ${instructor.getDetails()}"
    }
}
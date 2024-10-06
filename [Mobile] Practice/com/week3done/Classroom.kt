package com.week3done

class Classroom(
    private var roomNumber: Int,
    private var capacity: Int
) {
    fun getRoomNumber(): Int{
        return roomNumber
    }

    fun setRoomNumber(roomNumber: Int){
        if (roomNumber > 0){
            this.roomNumber = roomNumber
        } else println("Room Number cannot be negative")
    }

    fun getCapacity(): Int{
        return capacity
    }

    fun setCapacity(capacity: Int){
        if (capacity > 0){
            this.capacity = capacity
        } else println("Capacity cannot be negative")
    }

    private val schedules: MutableList<Schedule> = mutableListOf()

    fun addSchedule(schedule: Schedule) {
        schedules.add(schedule)
    }

    fun getSchedules(): List<Schedule> {
        return schedules.sortedBy { it.getTime() }
    }

    fun classroomInfo(): String {
        return "Classroom: $roomNumber, Capacity: $capacity"
    }

    fun printScheduledLessons() {
        val sortedSchedules = getSchedules()
        if (sortedSchedules.isEmpty()) {
            println("No scheduled lessons in classroom $roomNumber")
        } else {
            println("Scheduled lessons in classroom $roomNumber:")
            for (schedule in sortedSchedules) {
                println(schedule.getScheduleInfo())
            }
        }
    }
}
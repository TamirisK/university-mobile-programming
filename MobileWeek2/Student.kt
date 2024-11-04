package com.week2

class Student(
    name: String,
    surname: String,
    age: Int,

    var id: Int,
    var yearOfStudy: Int,
    var major: String
): Person(name, surname, age){


}
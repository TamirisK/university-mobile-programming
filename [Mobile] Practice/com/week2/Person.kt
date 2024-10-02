package com.week2

open class Person(
    var name: String,
    var surname: String,
    var age: Int
){

    override fun toString(): String{
        // fun getInfo(): String{
        return "Name: $name, Surname: $surname, Age: $age"
    }
}
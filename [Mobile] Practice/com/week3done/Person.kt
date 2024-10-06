package com.week3done

open class Person(
    private var name: String,
    private var age: Int,
    private var email: String
) {
    open fun getDetails(): String {
        return "Name: $name, Age: $age, Email: $email"
    }

    fun getName(): String{
        return name
    }

    fun setName(name: String){
        this.name = name
    }

    fun getAge(): Int{
        return age
    }

    fun setAge(age: Int){
        if (age > 0){
            this.age = age
        } else println("Age cannot be negative")
    }

    fun getEmail(): String{
        return email
    }

    fun setEmail(email: String){
        this.email = email
    }
}
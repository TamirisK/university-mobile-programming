import java.lang.NumberFormatException

fun variableDataTypes(){
    var name: String = "Name"
    var age: Int = 18
    var weight: Double = 50.5
    var majority: Boolean = true

    println("Name: $name, age: $age, weight: $weight, majority: $majority")
}

fun numberChecker(){
    while (true){
        println("Enter any number. To exit enter any word")

        try {
            var number:Int = readln().toInt()

            if (number > 0) println("Number $number is positive")
            if (number == 0) println("Number $number is zero")
            if (number < 0) println("Number $number is negative")

//            Another version of if case
//            number > 0 -> println("Number $number is positive")
//            number == 0 -> println("Number $number is zero")
//            number < 0 -> println("Number $number is negative")

        } catch (e: NumberFormatException){
            println("Not number entered \nGood Bye \nExiting...")
            break
        }
    }
}

fun printNumbers(){
    print("With For Loop: ")
    for (i in 1..10){
        print("$i ")
    }

    print("\nWith While Loop: ")
    var i: Int = 1
    while (i <= 10){
        print("$i ")
        i++
    }
}

fun sumOfNumbersList(){
    val numbers = listOf(1, 2, 3, 4, 5)
    val sum = numbers.sum()
    println("Numbers of the list is: $numbers")
    println("The sum of the list is: $sum")
}

// without list
fun sumOfNumbers(){
    var sum: Int = 0

    while (true){
        println("Enter any number. To exit enter any word")

        try {
            var number:Int = readln().toInt()
            sum += number
        } catch (e: NumberFormatException){
            println("Calculating..\nSum: $sum")
            break
        }
    }
}

fun main() {
    println("Exercise 1")

    println("\tTask 1. Variables and Data Types")
    variableDataTypes()

    println("\n\tTask 2. Conditional Statements")
    numberChecker()

    println("\n\tTask 3. Loops")
    printNumbers()

    println("\n\n\tTask 4. Collections")
    sumOfNumbersList()
    sumOfNumbers()
}
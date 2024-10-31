fun sumOfNumbers(x: Int, y: Int): Int {
    return x + y
}

fun multiplyOfNumbers(x: Int, y: Int): Int{
    return x * y
}

var multiplyOfNumbersLambda: (Int, Int) -> Int = { x, y -> x * y }

fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}


fun main(){
    println("Example 3")
    println("Enter 2 numbers")
    val number1:Int = readln().toInt()
    val number2:Int = readln().toInt()


    println("\tTask 1")
    println("Sum of $number1 and $number2 is: " + sumOfNumbers(number1, number2))


    println("\n\tTask 2")
    println("Multiply of $number1 and $number2 is: " + multiplyOfNumbers(number1, number2))
    println("Lambda multiply of $number1 and $number2 is: " + multiplyOfNumbersLambda(number1, number2))


    println("\n\tTask 3")
    val resultSumHigherOrder = applyOperation(10, 20, ::sumOfNumbers)
    println("Applying sum: $resultSumHigherOrder")

    val answerMultiplyOfNumbers = applyOperation(2, 3, ::multiplyOfNumbers)
    println("Applying multiply: $answerMultiplyOfNumbers")

    val answerMultiplyOfNumbersLambda = applyOperation(2, 3, multiplyOfNumbersLambda)
    println("Applying Lambda multiply : $answerMultiplyOfNumbersLambda")
}
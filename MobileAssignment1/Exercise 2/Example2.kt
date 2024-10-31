fun main() {
    val person = Person("Tamiris", 20, "tamiris@example.com")
    val employee = Employee("Tomas", 25, "tomas@example.com", 1000)

    val bankAccount = BankAccount(1000)


    println("Exercise 2")

    println("\tTask 1. Create a Person class")
    person.displayInfo()

    println("\n\n\tTask 2. Inheritance")
    employee.displayInfo()

    println("\n\tTask 3. Encapsulation")
    println("Initial Balance: $${bankAccount.getBalance()}")
    bankAccount.deposit(250)
    println("Balance after deposit: $${bankAccount.getBalance()}")
    bankAccount.withdraw(100)
    println("Balance after withdrawal: $${bankAccount.getBalance()}")
    bankAccount.withdraw(1200)
}
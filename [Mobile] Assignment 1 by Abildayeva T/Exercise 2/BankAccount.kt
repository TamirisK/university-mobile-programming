class BankAccount(
    private var balance: Int
) {
    fun getBalance(): Int {
        return balance
    }

    fun deposit(amount: Int) {
        if (amount > 0) {
            balance += amount
            println("Deposited: $$amount")
        } else {
            println("Amount cannot be negative")
        }
    }

    fun withdraw(amount: Int) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount
                println("Withdraw: $$amount")
            } else {
                println("Withdrawal failed: Insufficient funds $($amount). Your current balance is $$balance")
            }
        } else {
            println("Amount cannot be negative")
        }
    }
}
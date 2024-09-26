class Employee(
    name: String,
    age: Int,
    email: String,

    var salary: Int
) : Person (name, age, email){

    override fun displayInfo(){
        super.displayInfo()
        println(", Salary: $salary")
//        return "Name: $name, Age: $age, Email: $email, Salary: $salary"
    }
}
open class Person(
    var name: String,
    var age: Int,
    var email: String
) {

//    override fun toString(): String{
    open fun displayInfo(){
        print("Name: $name, Age: $age, Email: $email")
    }
}
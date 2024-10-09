class Person(val name: String, val surname: String) {
    var children = emptyList<Person>()

    init {
        println("Hi, my name is $name $surname.")
    }

    constructor(name: String, surname: String, parent: Person) : this(name, surname) {
        parent.addChild(this)
    }

    fun fullName(): String {
        return "$name $surname"
    }

    fun addChild(child: Person) {
        children += child
    }
}
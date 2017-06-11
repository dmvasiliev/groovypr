package fourth

/**
 * Created by vasiliev on 6/2/2017.
 */

class Person {
    def firstName, surName
    Integer age
    def address

    Person(firstName, surName, age, address) {
        this.firstName = firstName
        this.surName = surName
        this.age = age
        this.address = address
    }

    Integer plus(Person other) {
        return this.age + other.age
    }

    Integer minus(Person other) {
        return Math.abs(this.age - other.age)
    }

    @Override
    String toString() {
        return "${firstName}, ${surName}"
    }

    static def getPersonList() {
        def dmitry = new Person("dmitry", "vasiliev", 30, new Address(city: "Minsk", street: "Kropotkina", index: "221000"))
        def sergey = new Person("sergey", "petrov", 25, new Address(city: "Minsk", street: "Lenina", index: "222000"))
        def petr = new Person("Petr", "Ivanov", 20, new Address(city: "Minsk", street: "Gagarina", index: "223000"))
        def sidorov = new Person("Igor", "Sidorov", 15, new Address(city: "Minsk", street: "Kolasa"))
        [dmitry, sergey, petr, sidorov]
    }

    public static void main(String[] args) {
        def dmitry = new Person("Dmitry", "Vasiliev", 30, new Address("Minsk", "Kropotkina", "221000"))
        def sergey = new Person("Sergey", "Petrov", 25, new Address("Minsk", "Lenina", "222000"))
        def petr = new Person("Petr", "Ivanov", 20, new Address("Minsk", "Gagarina", "223000"))
        def sidorov = new Person("Igor", "Sidorov", 15, new Address("Minsk", "Kolasa", "224000"))

        def list = [dmitry, sergey, petr, sidorov]

//        list.sort { p1, p2 -> p1.age <=> p2.age }
//        print list.min() { it.age }
//        println list.findAll {it.age < 30}
        println dmitry.toString()
    }
}



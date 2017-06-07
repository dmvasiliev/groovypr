package fourth

/**
 * Created by vasiliev on 6/2/2017.
 */

class Person {
    def firstName, surName, age
    def address

    Person(firstName, surName, age, address) {
        this.firstName = firstName
        this.surName = surName
        this.age = age
        this.address = address
    }

    Person plus(Person other) {
        return new Person(this.age + other.age)
    }

    Person minus(Person other) {
        return new Person(this.age - other.age)
    }

    @Override
    String toString() {
        return  "${firstName}, ${surName}"
    }



    public static void main(String[] args) {
        def dmitry = new Person("Dmitry", "Vasiliev", 30, new Address("Minsk", "Kropotkina", "221000"))
        def ivan = new Person("Sergey", "Petrov", 25, new Address("Minsk", "Lenina", "222000"))
        def petr = new Person("Petr", "Ivanov", 20, new Address("Minsk", "Gagarina", "223000"))
        def sidorov = new Person("Igor", "Sidorov", 15, new Address("Minsk", "Kolasa", "224000"))
        def list = [dmitry, ivan, petr, sidorov]
//        list.sort { p1, p2 -> p1.age <=> p2.age }
//        print list.min() { it.age }
//        println list.findAll {it.age < 30}
        println dmitry.toString()
    }
}


class Address {
    def city, street, index

    Address(city, street, index) {
        this.city = city
        this.street = street
        this.index = index
    }
}
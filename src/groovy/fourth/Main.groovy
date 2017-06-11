package fourth

/**
 * Created by vasiliev on 6/8/2017.
 */
class Main {
    public static void main(String[] args) {
        //4 Написать класс Person (с некоторым набором свойств, к примеру firstName, surName, address (city, street, index) , age);
        def dmitry = new Person("dmitry", "vasiliev", 30, new Address(city: "Minsk", street: "Kropotkina", index: "221000"))
        def sergey = new Person("sergey", "petrov", 25, new Address(city: "Minsk", street: "Lenina", index: "222000"))
        def petr = new Person("Petr", "Ivanov", 20, new Address(city: "Minsk", street: "Gagarina", index: "223000"))
        def sidorov = new Person("Igor", "Sidorov", 15, new Address(city: "Minsk", street: "Kolasa", index: "224000"))

        //4.1 Добавить к классу Integer и интерфейсу List несколько методов (один из них должен быть статическим),
        //используя возможности метапрограммирования в Groovy;
        new NewInteger()
        new NewList()

        def list1 = new ArrayList<String>()
        list1 << "a"
        list1 << "b"
        list1 << "c"

        def list2 = new ArrayList<String>()
        list2 << "а"
        list2 << "б"
        list2 << "в"

        def list3 = new ArrayList<String>()
        list3 << "1"
        list3 << "2"
        list3 << "3"

        list3.printAllList(list1, list2)
        println Integer.multiplyTwo(40)

        // 4.2 Задать объект, типа Сlosure, который принимает несколько параметров (Integer, String, Closure). Затем вызвать closure явным и неявным образом.
        //В чем отличие метода от closure?
        println "explicit call:"
        MyClosure.doSomething.call(dmitry.toString(), dmitry.age, MyClosure.capitalizeAllWords)
        println "implicit call:"
        MyClosure.doSomething(sergey.toString(), sergey.age, MyClosure.capitalizeAllWords)

        //4.3
        //4.3.1. Определить для объектов класса методы '+', '-';
        println "Суммарный возраст двух персон: ${dmitry + sergey}"
        println "Разница в возрасте ${dmitry - sergey}"

        //4.3.2. Определить метод toString, который выводит "${firstName}, ${surName}"
        println dmitry.toString()

        //4.3.3. Среди объектов типа Person найти такие, у которых возраст (age) менее 30 лет;
        def list = [dmitry, sergey, petr, sidorov]
        println list.findAll { it.age < 30 }

        //4.3.4. Вывести все различные адреса, которые есть у списка объектов Person;
        def allAddress = []
        list.each {
            if (!allAddress.contains(it.address)) {
                allAddress << it.address
            }
        }
        println "All unique address: ${allAddress}"

        //4.3.5. Переопределить метод toString, не меняя описания класса Person (к примеру теперь пусть выводит "${surName} ${firstName} (${age})").
        def person_before = new Person("Igor", "Sidorov", 15, new Address(city: "Minsk", street: "Kolasa", index: "224000"))
        person_before.metaClass.toString = {
            "${surName} ${firstName} (${age})"
        }
        println person_before.toString()
    }
}

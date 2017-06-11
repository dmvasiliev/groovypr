package seventh
/**
 * Created by vasiliev on 6/9/2017.
 */
class Main {
    public static void main(String[] args) {
        //7.1. Возвести число 4 в 5 степень;
        println MyMath.numberToPower()

        //7.2. Написать closure printValue,которое если аргумент не null выводит его значение, иначе выводит 'no value'(без оператора 'if')
        println(MyMath.printValue())

        //7.3. У каждого объекта Person вывести значение index (свойство адреса), учитывая что у некоторых объектов Person адреса нету (без оператора 'if')
        MyMath.printPersonsIndex()
    }
}

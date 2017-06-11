//package script
//println("hello")

class Persons {
    def fname
    def lname
    def age
    def address
    def contactNumbers
    String toString(){

        def numstr = new StringBuffer()
        if (contactNumbers != null){
            contactNumbers.each{
                numstr.append(it)
                numstr.append(" ")
            }
        }
        "first name: " + fname + " last name: " + lname +
                " age: " + age + " address: " + address +
                " contact numbers: " + numstr.toString()
    }
}
/*
class Address {
    def street1
    def street2
    def city
    def state
    def zip
    String toString(){
        "street1: " + street1 + " street2: " + street2 +
                " city: " + city + " state: " + state + " zip: " + zip
    }
}

class ContactNumber {
    def type
    def number
    String toString(){
        "Type: " + type + " number: " + number
    }
}

nums = [new ContactNumber(type:"cell", number:"555.555.9999"), new ContactNumber(type:"office", number:"555.555.5598")]
addr = new Address(street1:"89 Main St.", street2:"Apt #2", city:"Utopia", state:"VA", zip:"34254")
pers = new Person(fname:"Mollie", lname:"Smith", age:34, address:addr, contactNumbers:nums)
println pers.toString()
*/

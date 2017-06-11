package seventh

import fourth.Person

/**
 * Created by vasiliev on 6/9/2017.
 */
class MyMath {

    static def numberToPower() {
        return 4**5
    }

    static def printValue = {
        it != null ? it : 'no value'
    }

    static def printPersonsIndex = {
        Person.getPersonList().each {
            println it.getAddress().index ? "${it.firstName}'s index: ${it.getAddress().index}" : "${it.firstName}'s index: no index"
        }
    }
}

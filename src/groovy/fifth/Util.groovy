package fifth

import groovy.transform.Synchronized

/**
 * Created by Dmitry on 08.06.2017.
 */
class Util {
    private counter = 0

    private def list = ['Groovy']

    private Object listLock = new Object[0]

    @Synchronized
    void workOnCounter() {
        assert 0 == counter
//        println (0 == counter)
        counter++
        println counter
        assert 1 == counter
        counter --
        println counter
        assert 0 == counter
    }

    @Synchronized('listLock')
    void workOnList() {
        assert 'Groovy' == list[0]
        list << 'Grails'
        assert 2 == list.size()
        list = list - 'Grails'
        assert 'Groovy' == list[0]
    }
}
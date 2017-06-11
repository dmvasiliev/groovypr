package fourth

import groovy.transform.EqualsAndHashCode

/**
 * Created by vasiliev on 6/8/2017.
 */
@EqualsAndHashCode
class Address {
    def city, street, index


    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", street=" + street +
                ", index=" + index +
                '}';
    }
}

package eighth

/**
 * Created by vasiliev on 6/9/2017.
 */
class MySriptThrClassLoader {

    def method() {
        def gcl = new GroovyClassLoader()
        def clazz = gcl.parseClass('class Foo { void doIt() { println "ok" } }')
        assert clazz.name == 'Foo'
        def o = clazz.newInstance()
        o.doIt()
    }
}

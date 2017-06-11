package eighth

import org.codehaus.groovy.control.CompilerConfiguration

/**
 * Created by vasiliev on 6/9/2017.
 */
class Main {
    public static void main(String[] args) {

        GroovyShell shell = new GroovyShell();
        Object result = shell.evaluate(new File("d:/java stady/groovypr/src/groovy/script/GroovyScript.groovy"));
        System.out.println("result=" + result);

/*        useShell()
        println ""
        println "------------------------------------------------------------------------------"
        println ""

        useShell2()

        println ""
        println "------------------------------------------------------------------------------"
        println ""

        useClassLoader()

        println ""
        println "------------------------------------------------------------------------------"
        println ""

        greateMethod()

        println ""
        println "------------------------------------------------------------------------------"
        println ""

        groovyScriptEngine()*/
    }

    static void groovyScriptEngine() {
        def binding = new Binding()
        def engine = new GroovyScriptEngine()

        while (true) {
            def greeter = engine.run('script.ReloadingTest.groovy', binding)
            println greeter.sayHello()
            Thread.sleep(1000)
        }
    }

    static void greateMethod() {
        def config = new CompilerConfiguration()
        config.scriptBaseClass = 'SecondScript'

        def shell = new GroovyShell(this.class.classLoader, new Binding(), config)
        def script = shell.parse('greet()')
        println "script instanceof MyScript: ${script instanceof MyScript}"
        script.setName('Michel')
        println "script.run() == 'Hello, Michel!':          ${script.run() == 'Hello, Michel!'}"
    }

    private static void useClassLoader() {
        def gcl = new GroovyClassLoader()
        def clazz = gcl.parseClass('class Foo { void doIt() { println "ok" } }')
        assert clazz.name == 'Foo'
        def o = clazz.newInstance()
        o.doIt()
    }

    private static void useShell2() {
        def shell = new GroovyShell()
        def result = shell.evaluate '3*5'
        def result2 = shell.evaluate(new StringReader('3*5'))
        println "result == result2: ${result == result2}"
        def script = shell.parse '3*5'
        println "script instanceof groovy.lang.Script:          ${script instanceof Script}"
        println "script.run() == 15: ${script.run() == 15}"
    }

    static def useShell() {
        def sharedData = new Binding()
        def shell = new GroovyShell(sharedData)

        //use string
        def now = new Date()
        sharedData.setProperty('text', 'I am shared data!')
        sharedData.setProperty('date', now)

        String result = shell.evaluate('"At $date, $text"')
        println result
        println ""

        //use file
        println shell.evaluate(new File("./src/groovy/eighth/MyScript.groovy"))
    }
}

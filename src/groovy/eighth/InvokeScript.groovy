package eighth

/**
 * Created by vasiliev on 6/9/2017.
 */
class InvokeScript {
    public static void main(String[] args) {
        File sourceFile = new File("e:\\test\\spoke\\src\\groovy\\script\\Song.groovy");
        Class groovyClass = new GroovyClassLoader(getClass().getClassLoader()).parseClass(sourceFile);
        GroovyObject myObject = (GroovyObject) groovyClass.newInstance();



/*        def script = new GroovyScriptEngine("e:\\test\\spoke\\src\\groovy\\script\\Person.groovy").with {
            loadScriptByName( 'file1.groovy' )
        }*/
    }
}

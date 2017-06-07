package third

import groovy.io.FileType

/**
 * Created by vasiliev on 5/6/2017.
 */
class ThirdTask {
    static def renameTxtFiles() {
        new File("e:/test/testDirectory").traverse(type : FileType.FILES, nameFilter: ~/\d+\.txt/) { it ->
            def fullFileName = it.getName()
            def shortFileName = fullFileName.take(fullFileName.lastIndexOf('.'))
            def sum = 0
            shortFileName.each {
                sum += it as Integer
            }
            (it as File).renameTo("${it.getParentFile().getCanonicalPath()}${File.separator}${shortFileName.reverse()}_${sum}.dat")
        }
    }
}

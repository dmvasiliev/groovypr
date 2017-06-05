package second

import groovy.io.FileType

import static groovy.io.FileType.FILES

/**
 * Created by vasiliev on 6/2/2017.
 */
class SecondTask {

    static void main(String[] args) {
//        findFiles()
        testTraverce()
    }
/*
2.1. Просканировать заданную папку на диске. Найти все файлы, подпадающие под шаблон:
название файла (без учета расширения) заканчивается словом 'groovy'.
Результат поиска представить в виде списка записей и вывести его.
Запись имеет вид типа:
FileName
Quantity Files(количество файлов в вложенных папках соответствующие введенному шаблону)
Size (in kb)
*/

    static def findFiles(Closure closure) {

        def list = []
        new File("src").eachFileRecurse(FileType.ANY) {
            def file = new File(it.toString())
            def info = new FileInfo()
            if (file.isDirectory()) {
                info.fileName = file.getName()
                def countFiles = 0
                new File(it.toString()).eachFile {
                    if (it.name =~ /\w+Test\.groovy/) {
                        countFiles++
                    }
                }
                info.quantityFiles = countFiles
                info.fileSize = file.directorySize() / 1024
            }
            if (file.isFile()) {
                info.fileName = file.getName()
                info.quantityFiles = ""
                info.fileSize = file.length() / 1024
            }
            list << info
        }
        list.each { println(it.fileName + " " + it.quantityFiles + " " + it.fileSize) }
    }


    static def testTraverce() {
        def groovySrcDir = new File('src')

        def countFilesAndDirs = 0
        groovySrcDir.traverse {
            countFilesAndDirs++
        }
        println "Total files and directories in ${groovySrcDir.name}: $countFilesAndDirs"

        def totalFileSize = 0
        def groovyFileCount = 0
        def sumFileSize = {
            totalFileSize += it.size()
            groovyFileCount++
        }
        def filterGroovyFiles = ~/.*\.groovy$/
        groovySrcDir.traverse type: FILES, visit: sumFileSize, nameFilter: filterGroovyFiles
        println "Total file size for $groovyFileCount Groovy source files is: $totalFileSize"

        def countSmallFiles = 0
        def postDirVisitor = {
            if (countSmallFiles > 0) {
                println "Found $countSmallFiles files with small filenames in ${it.name}"
            }
            countSmallFiles = 0
        }
        groovySrcDir.traverse(type: FILES, postDir: postDirVisitor, nameFilter: ~/.*\.groovy$/) {
            if (it.name.size() < 15) {
                countSmallFiles++
            }

        }

    }
}

class FileInfo {
    def fileName
    def quantityFiles
    def fileSize
}
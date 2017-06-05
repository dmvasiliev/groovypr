package second

import groovy.io.FileType

/**
 * Created by vasiliev on 6/2/2017.
 */
class SecondTask {

    static void main(String[] args) {
        findFiles()
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
        new File("src").eachFileRecurse(FileType.FILES) {
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
                info.fileSize = file.directorySize()
            }
            if (file.isFile()) {
                info.fileName = file.getName()
                info.fileSize = file.length() / 1024
            }
            list << info
        }
        list.each {println(it.fileName + " " + it.quantityFiles + " " + it.fileSize)}
    }
}

class FileInfo {
    def fileName
    def quantityFiles
    def fileSize
}
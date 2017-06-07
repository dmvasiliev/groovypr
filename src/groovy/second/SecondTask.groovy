package second

import groovy.io.FileType
import groovy.xml.MarkupBuilder

/**
 * Created by vasiliev on 6/2/2017.
 */
class SecondTask {

    static void main(String[] args) {
        findFiles()
        createXML()
    }

    static def findFiles() {
        def list = []
        new File("e:\\test\\testDirectory\\").eachFileRecurse(FileType.ANY) {
            def file = new File(it.toString())
            def info = new FileInfo()
            if (file.isDirectory()) {
                info.fileName = file.getName()
                def countFiles = 0
                new File(it.toString()).traverse(type: FileType.FILES, nameFilter: ~/.*?groovy\..*/) { f ->
                    countFiles++
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

    static def createXML() {
        List<FileInfo> files = findFiles()
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.Folders(rootPath: "e:/test/testDirectory") {
            files.each {
                if (it.quantityFiles == "") {
                    File(fileName: it.fileName, fileSize: it.fileSize)
                } else {
                    Directory(fileName: it.fileName, quantityFiles: it.quantityFiles, fileSize: it.fileSize)
                }
            }
        }
        println writer.toString()
    }
}

class FileInfo {
    def fileName
    def quantityFiles
    def fileSize
}


/*    static def folderInfo() {
        new File("e:\\test\\testDirectory\\").eachFile(FileType.ANY) {
            def countFiles = 0
            def file = new File(it.toString())
            def map = [:]
            if (file.isDirectory()) {
                new File(it.toString()).traverse(type: FileType.FILES, nameFilter: ~/.*?groovy\..*//*) { f ->
                    countFiles++
                }
            }
        }
    }*/

/*    static def folderInfo() {
        def list = []
        new File("e:\\test\\testDirectory\\").eachFile(FileType.ANY) {
            def file = new File(it.toString())
            def info = new FileInfo()

            if (file.isDirectory()) {
                def countFiles = 0
                new File(it.toString()).traverse(type: FileType.FILES, nameFilter: ~/.*?groovy\..*//*) { f ->
                    countFiles++
                }
                info.fileName = file.getName()
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
    }*/

/*    static def createFolderXML() {
        List<FileInfo> files = findFiles()
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.Folders(rootPath: "e:/test/testDirectory") {
            files.each {
                if (it.quantityFiles == "") {
                    File(fileName: it.fileName, fileSize: it.fileSize)
                } else {
                    Directory(fileName: it.fileName, quantityFiles: it.quantityFiles, fileSize: it.fileSize)
                }
            }
        }
        println writer.toString()
    }*/



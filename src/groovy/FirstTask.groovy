/**
 * Created by vasiliev on 6/2/2017.
 */
class FirstTask {

    public static void main(String[] args) {
//        findAllWordsInLowercase()
//        getStrFrom11To16()
        getOnlyEnglishLetters()
//        capitalizeAllWords()
    }

    static def findAllWordsInLowercase(def task) {
        def words = task.split(" ")
        def list = []
        words.findAll { word ->
            if (word.toLowerCase() == word) {
                list << word
            }
        }
        list
    }

    static def getStrFrom11To16(String task) {
        if (task.length() > 16) {
            task[10..15]
        }
    }

    static def getOnlyEnglishLetters(String string) {
        string.findAll { it =~ '\\w[a..z]*' }
    }

    static def capitalizeAllWords() {
        def task = "поменять во всех словах строки первую букву на заглавную;"
        println task
        def list = []
        task.each { list << it.capitalize() }
        println list
        println ""
    }

}
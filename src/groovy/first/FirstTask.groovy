package first
/**
 * Created by vasiliev on 6/2/2017.
 */
class FirstTask {

    public static void main(String[] args) {
//        findAllWordsInLowercase()
//        getStrFrom11To16()
//        getOnlyEnglishLetters()
        println capitalizeAllWords("поменять во всех словах строки  6 первую букву на заглавную")
        println reverseString("поменять во всех bob строки reviver букву на rotator drotatord")
        println hasEmail("jkldfjgldfk ffff6f@tttt.yt  dflgkjdfklg lkdfjgd  ffff6f@tttt.yt dfklgjdfklgjl")
    }

    static def findAllWordsInLowercase(def string) {
        def words = string.split(" ")
        def list = []
        words.findAll { word ->
            if (word.toLowerCase() == word) {
                list << word
            }
        }
        list
    }

    static def getStrFrom11To16(String string) {
        if (string.length() > 16) {
            string[10..15]
        }
    }

    static def getOnlyEnglishLetters(String string) {
        string.findAll { it =~ '[a-z]' }
    }

    static def capitalizeAllWords(String string) {
        def capitalizeList = []
        string.tokenize(" ").each({
            capitalizeList << it.capitalize()
        })
        capitalizeList.join(" ")
    }

    static def reverseString(String string) {
        def list = []
        string.tokenize().each {
            if (it == it.reverse() && it.toSet().size() < 5) {
                list << it
            }
        }
        list
    }

    static def hasEmail(String string) {
        (string =~ /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,4}/).count > 0
    }
}
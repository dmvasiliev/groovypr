import spock.lang.Specification

/**
 * Created by vasiliev on 6/2/2017.
 */
class FirstTaskTest extends Specification {
    def allLowercaseLetter = "найти ВСЕ слова содержащие ТОЛЬКО буквы НИЖНЕГО РЕГИСТРА"
    def allLettersFrom_11_To_16 = "вывести все символы с 11-го по 16-ый (с учетом, что строка больше 16 символов)"



    def "найти все слова содержащие только буквы нижнего регистра"() {
        expect: FirstTask.findAllWordsInLowercase(allLowercaseLetter) ==  ["найти", "слова", "содержащие", "буквы"]
    }

    def "вывести символы с 11-го по 16-ый (с учетом, что строка больше 16 символов)"() {
        expect: FirstTask.getStrFrom11To16(allLettersFrom_11_To_16) ==  "е симв"
    }

    def "вывести все буквы английского алфавита (нижний регистр)"() {
        expect: FirstTask.getOnlyEnglishLetters("123ПРОЛОРa78Bb ыыc/d][]'e~fGRKLMj42 ,.;'k") ==  ["a","b","c","d","e","f","j","k"]
    }
}

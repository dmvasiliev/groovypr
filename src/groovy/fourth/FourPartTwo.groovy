package fourth

class FourPartTwo {

    static Closure doSomething = { String fio, Integer age, Closure closure ->
        def fi = closure(fio)
        println "First and last name: ${fi}; age: ${age}"
    }

    static Closure capitalizeAllWords = { String string ->
        def capitalizeList = []
        string.tokenize(" ").each({
            capitalizeList << it.capitalize()
        })
        capitalizeList.join(" ")
    }

    public static void main(String[] args) {
        def dmitry = new Person("dmitry", "vasiliev", 30, new Address("Minsk", "Kropotkina", "221000"))
        println "explicit call:"
        doSomething.call(dmitry.toString(), dmitry.age, capitalizeAllWords)
        println "implicit call:"
        doSomething(dmitry.toString(), dmitry.age, capitalizeAllWords)
    }
}


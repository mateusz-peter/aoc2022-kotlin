package common

fun resourceAsLines(fileName: String): Sequence<String> {
    return object {}.javaClass
        .getResourceAsStream(fileName)!!
        .bufferedReader()
        .lineSequence()
}

fun resourceAsString(fileName: String) : String {
    return object {}.javaClass
        .getResource(fileName)
        ?.readText()!!
}
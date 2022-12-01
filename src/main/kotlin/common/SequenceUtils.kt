package common

fun Sequence<String>.splitByEmptyLines(): Sequence<List<String>> {
    return SplitSeq(this, String::isEmpty)
}

fun <T> Sequence<T>.splitBy(predicate: (T) -> Boolean): Sequence<List<T>> {
    return SplitSeq(this, predicate)
}

class SplitSeq<T>(private val seq: Sequence<T>, private val splitBy: (T) -> Boolean) : Sequence<List<T>> {
    override fun iterator(): Iterator<List<T>> {
        return object : Iterator<List<T>> {
            val iterator = seq.iterator()

            override fun hasNext(): Boolean {
                return iterator.hasNext()
            }

            override fun next(): List<T> {
                val list = mutableListOf<T>()
                while (iterator.hasNext()) {
                    val next = iterator.next()
                    if(!splitBy(next)) {
                        list += next
                    } else {
                        break
                    }
                }
                return list
            }
        }
    }
}
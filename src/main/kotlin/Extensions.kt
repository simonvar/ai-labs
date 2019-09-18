fun <T> List<T>.swap(a: Int, b: Int): List<T> = this
    .toMutableList()
    .also {
        it[a] = this[b]
        it[b] = this[a]
    }


fun Int.listPosition(x: Int, y: Int): Int {
    return y * this + x
}

fun Int.xyPosition(index: Int): Pair<Int, Int> {
    return index % this to index / this
}
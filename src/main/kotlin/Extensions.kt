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

fun <T, F> Node<T>.fold(acc: F, compute: (F, T) -> F): F {
    var result = acc
    forEach {
        result = compute(result, it)
    }
    return result
}

fun Int.toCell(): Cell = Cell.NormalCell(this)

fun <T> Node<T>.forEach(comput: (T) -> Unit) {
    comput(value)
    nextNodes.forEach {
        it.forEach(comput)
    }
}

fun Desc.moveAll() : List<Desc> {
    return sequenceOf(
        move(Desc.Movement.RIGHT),
        move(Desc.Movement.DOWN),
        move(Desc.Movement.LEFT),
        move(Desc.Movement.UP)
    ).filterNotNull().toList()
}
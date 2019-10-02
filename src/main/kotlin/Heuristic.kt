import kotlin.math.abs

interface Heuristic : (Desc) -> Float

class H1(
    private val finishDesc: Desc
) : Heuristic {

    override fun invoke(desc: Desc): Float {
        return desc
            .zip(finishDesc) { left, right -> left != right }
            .count { it }
            .toFloat()
    }
}

class H2(
    private val finishDesc: Desc
) : Heuristic {

    override fun invoke(desc: Desc): Float {
        return desc
            .map {
                val actual = desc.position(it)
                val expected = finishDesc.position(it)
                abs(actual.first - expected.first + actual.second - expected.second)
            }
            .reduce { acc, i ->
                acc + i
            }
            .toFloat()
    }

}
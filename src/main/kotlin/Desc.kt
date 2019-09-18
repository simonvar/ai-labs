import kotlin.IllegalArgumentException
import kotlin.math.sqrt

data class Desc(private val cells: List<Cell>) {

    private val emptyPosition by lazy {
        cells.indexOfFirst {
            it is Cell.EmptyCell
        }
    }

    private val columnSize = sqrt(cells.size.toDouble()).toInt()

    init {
        if (columnSize * columnSize != cells.size) throw IllegalArgumentException("Illegal list size")
    }

    enum class Movement(
        val x: Int,
        val y: Int
    ) {
        UP(0, -1),
        RIGHT(1, 0),
        DOWN(0, 1),
        LEFT(-1, 0)
    }

    fun move(movement: Movement): Desc? {
        val (x, y) = columnSize.xyPosition(emptyPosition)
        val newX = movement.x + x
        val newY = movement.y + y
        val newListPosition = columnSize.listPosition(newX, newY)

        if (newX < 0 || newX >= columnSize || newY < 0 || newY >= columnSize) {
            return null
        }

        return Desc(
            cells.swap(emptyPosition, newListPosition)
        )
    }

    override fun toString(): String {
        return cells.foldIndexed("") { index, acc, cell ->
            val separator = if ((index + 1) % columnSize == 0) {
                if (index != cells.size - 1) {
                    "\n"
                } else {
                    ""
                }
            } else {
                "  "
            }
            "$acc$cell$separator"
        }
    }

}
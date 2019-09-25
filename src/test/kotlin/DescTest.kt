import org.junit.Assert
import org.junit.Test
import kotlin.IllegalArgumentException

class DescTest {

    @Test(expected = IllegalArgumentException::class)
    fun `test illegal list`() {
        val list = listOf(Cell.NormalCell(1), Cell.EmptyCell)
        Desc(list)
    }

    @Test
    fun `test legal list`() {
        val list = listOf(Cell.EmptyCell)
        Desc(list)
    }

    @Test
    fun `test move`() {
        val normalCell = Cell.NormalCell(1)
        val cells = listOf(
            normalCell, normalCell, normalCell,
            normalCell, Cell.EmptyCell, normalCell,
            normalCell, normalCell, normalCell
        )
        val desc = Desc(cells)
        val newDesc = desc
            .move(Desc.Movement.RIGHT)
            ?.move(Desc.Movement.DOWN)
            ?.move(Desc.Movement.LEFT)
            ?.move(Desc.Movement.UP)

        Assert.assertEquals(desc, newDesc)
    }

    @Test
    fun `test illegal move`() {
        val normalCell = Cell.NormalCell(1)
        val cells = listOf(
            normalCell, normalCell, normalCell,
            normalCell, normalCell, normalCell,
            normalCell, normalCell, Cell.EmptyCell
        )

        Assert.assertEquals(null, Desc(cells).move(Desc.Movement.RIGHT))
    }

    @Test
    fun `equals test`() {
        val cells = listOf(
            7.toCell(), 4.toCell(), 2.toCell(),
            3.toCell(), 5.toCell(), 8.toCell(),
            7.toCell(), 1.toCell(), Cell.EmptyCell
        )
        val finishCells = listOf(
            7.toCell(), 4.toCell(), 2.toCell(),
            3.toCell(), 5.toCell(), 8.toCell(),
            7.toCell(), 1.toCell(), Cell.EmptyCell
        )
        Assert.assertEquals(cells, finishCells)
    }

    @Test
    fun `test to string`() {
        val normalCell = Cell.NormalCell(1)
        val cells = listOf(
            normalCell, normalCell, normalCell,
            normalCell, Cell.EmptyCell, normalCell,
            normalCell, normalCell, normalCell
        )
        val desc = Desc(cells)

        val descString = """
            1  1  1
            1  @  1
            1  1  1
        """.trimIndent()

        val actual = desc.toString()
        println(actual)
        Assert.assertEquals(descString, actual)
    }

}
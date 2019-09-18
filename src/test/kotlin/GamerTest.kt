import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GamerTest {

    @Test
    fun `test correct solve`() {
        val cells = listOf(
            3.toCell(), 4.toCell(), 1.toCell(),
            5.toCell(), Cell.EmptyCell, 2.toCell(),
            6.toCell(), 8.toCell(), 7.toCell()
        )
        val finishCells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            4.toCell(), 5.toCell(), 6.toCell(),
            7.toCell(), 8.toCell(), Cell.EmptyCell
        )
        val desc = Desc(cells)
        val finishDesc = Desc(finishCells)
        val gamer = Gamer(finishDesc) {
            println(it)
            println()
        }
        Assert.assertEquals(finishDesc, gamer.invoke(desc))
    }

    private fun Int.toCell(): Cell = Cell.NormalCell(this)
}
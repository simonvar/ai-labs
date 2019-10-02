import org.junit.Assert
import org.junit.Test

class HeuristicsTest {

    @Test
    fun `h1 test`() {
        val cells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            4.toCell(), 5.toCell(), 6.toCell(),
            8.toCell(), 7.toCell(), Cell.EmptyCell
        )

        val finishCells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            4.toCell(), 5.toCell(), 6.toCell(),
            7.toCell(), 8.toCell(), Cell.EmptyCell
        )

        val actualDesc = Desc(cells)
        val finishDesc = Desc(finishCells)

        val h1 = H1(finishDesc)

        Assert.assertEquals(2F, h1(actualDesc))
    }

    @Test
    fun `h2 test`() {
        val cells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            4.toCell(), 5.toCell(), 6.toCell(),
            8.toCell(), 7.toCell(), Cell.EmptyCell
        )

        val finishCells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            4.toCell(), 5.toCell(), 6.toCell(),
            7.toCell(), 8.toCell(), Cell.EmptyCell
        )

        val actualDesc = Desc(cells)
        val finishDesc = Desc(finishCells)

        val h2 = H2(finishDesc)

        Assert.assertEquals(2F, h2(actualDesc))
    }

    @Test
    fun `h2 test finish`() {
        val cells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            4.toCell(), 5.toCell(), 6.toCell(),
            7.toCell(), 8.toCell(), Cell.EmptyCell
        )

        val finishCells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            4.toCell(), 5.toCell(), 6.toCell(),
            7.toCell(), 8.toCell(), Cell.EmptyCell
        )

        val actualDesc = Desc(cells)
        val finishDesc = Desc(finishCells)

        val h2 = H2(finishDesc)

        Assert.assertEquals(0F, h2(actualDesc))
    }



}
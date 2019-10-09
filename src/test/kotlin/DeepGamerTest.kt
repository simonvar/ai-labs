import gamer.DeepGamer
import org.junit.Assert
import org.junit.Test

class DeepGamerTest {
    @Test
    fun `test correct solve`() {
        val cells = listOf(
            4.toCell(), 8.toCell(), 1.toCell(),
            Cell.EmptyCell,3.toCell(), 6.toCell(),
            2.toCell(), 7.toCell(), 5.toCell()
        )

        val finishCells = listOf(
            1.toCell(), 2.toCell(), 3.toCell(),
            8.toCell(), Cell.EmptyCell, 4.toCell(),
            7.toCell(), 6.toCell(), 5.toCell()
        )
//        val finishCells = listOf(
//            7.toCell(), 4.toCell(), 2.toCell(),
//            Cell.EmptyCell, 5.toCell(), 8.toCell(),
//            3.toCell(), 6.toCell(),  1.toCell()
//        )

        val desc = Desc(cells)
        val finishDesc = Desc(finishCells)
        var i = 0
        val resultGame = DeepGamer(finishDesc, 50) {
            println(i)
            println(it)
            i++
        }
        Assert.assertEquals(finishDesc, resultGame.invoke(desc))
    }


}
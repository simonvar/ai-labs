import org.junit.Assert
import org.junit.Test

class ExtensionsTest {

    @Test
    fun `from linear to square`() {
        Assert.assertEquals(3.xyPosition(4), 1 to 1)
        Assert.assertEquals(4.xyPosition(0), 0 to 0)
        Assert.assertEquals(5.xyPosition(24), 4 to 4)
    }

    @Test
    fun `from square to linear`() {
        Assert.assertEquals(3.listPosition(1, 1), 4)
        Assert.assertEquals(4.listPosition(0, 0), 0)
        Assert.assertEquals(5.listPosition(4, 4), 24)
    }

    @Test
    fun `list items swap`() {
        val list = listOf(1, 2, 3, 4)
        Assert.assertEquals(list.swap(1, 2), listOf(1, 3, 2, 4))
    }

    @Test
    fun `to cell test`() {
        Assert.assertEquals(1.toCell(), Cell.NormalCell(1))
    }

    @Test
    fun `graph fold`() {
        val graph = Node(3, listOf(
            Node(4, emptyList()),
            Node(5, emptyList())
        ))
        val sum = 12
        val actualSum = graph.fold(0) { acc: Int, item: Int ->
            acc + item
        }
        Assert.assertEquals(sum, actualSum)
    }

}
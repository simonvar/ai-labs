import java.lang.IllegalArgumentException

class Gamer(
    private val finishDesc: Desc,
    private val visitor: (Desc) -> Unit
) : (Desc) -> Desc {

    override fun invoke(desc: Desc): Desc {
        val head = Node(desc)
        return next(head, 0, head)?.value ?: throw IllegalArgumentException()
    }

//    private fun next(head: Node<Desc>, prevNodes: List<Node<Desc>>): List<Node<Desc>> {
//        return next(head, prevNodes.map {
//                visitor(it.value)
//                if (it.value == finishDesc) return listOf(Node(it.value))
//                val descs = it.value.moveAll()
//                val newDescs = head.fold(descs) { acc, node ->
//                    acc.filter { it != node }
//                }
//                it.nextNodes = newDescs.map { Node(it) }
//                it.nextNodes
//            }.fold(mutableListOf()) { acc, nodes ->
//            acc.addAll(nodes)
//            acc
//        })
//    }

    private fun next(head: Node<Desc>, deep: Int, prevNode: Node<Desc>): Node<Desc>? {
        visitor(prevNode.value)
        if (prevNode.value == finishDesc) return prevNode
        if (deep == 32) {
            return null
        }
        val descs = prevNode.value.moveAll()
        val newDescs = head.fold(descs) { acc, node ->
            acc.filter { it != node }
        }
        prevNode.nextNodes = newDescs.map { Node(it) }
        prevNode.nextNodes.forEach {
            val next = next(head, deep + 1, it)
            if (next != null) return next
        }
        return null
    }

    private fun Desc.moveAll() : List<Desc> {
        return sequenceOf(
            move(Desc.Movement.RIGHT),
            move(Desc.Movement.DOWN),
            move(Desc.Movement.LEFT),
            move(Desc.Movement.UP)
        ).filterNotNull().toList()
    }
}
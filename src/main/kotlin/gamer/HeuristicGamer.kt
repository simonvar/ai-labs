package gamer

import Desc
import Heuristic
import Node
import fold
import moveAll

class HeuristicGamer(
    private val heuristic: Heuristic,
    private val visitor: (Desc) -> Unit
) : (Desc) -> Desc {

    override fun invoke(desc: Desc): Desc {
        val head = Node(desc)
        return next(head, head)?.value ?: throw IllegalArgumentException()
    }

    private fun next(head: Node<Desc>, prevNode: Node<Desc>): Node<Desc>? {
        visitor(prevNode.value)

        val descs = prevNode.value.moveAll()
        val newDescs = head.fold(descs) { acc, item ->
            //            acc.filter { heuristic(it) <= heuristic(item) }
            acc.filter { it != item }
        }
        val newDesc = head.fold(newDescs) { acc, item ->
            //            acc.filter { heuristic(it) <= heuristic(item) }
            acc.filter { heuristic(it) <= heuristic(item) }
        }
        prevNode.nextNodes = newDesc.map { Node(it) }
        prevNode.nextNodes.forEach {
            val next = next(head, it)
            if (next != null) return next
        }

        return null
    }

}

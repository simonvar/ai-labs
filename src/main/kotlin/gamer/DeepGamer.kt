package gamer

import Desc
import Node
import fold
import moveAll
import java.lang.IllegalArgumentException

class DeepGamer(
    private val finishDesc: Desc,
    private val visitor: (Desc) -> Unit
) : (Desc) -> Desc {

    override fun invoke(desc: Desc): Desc {
        val head = Node(desc)
        return next(head, 0, head)?.value ?: throw IllegalArgumentException()
    }

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
}
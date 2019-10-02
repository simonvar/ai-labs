package gamer

import Desc
import Node
import fold
import moveAll

class Gamer(
    private val finishDesc: Desc,
    private val visitor: (Desc) -> Unit
) : (Desc) -> Desc {

    override fun invoke(desc: Desc): Desc {
        val head = Node(desc)
        return next(head, listOf(head)).first().value
    }

    private fun next(head: Node<Desc>, prevNodes: List<Node<Desc>>): List<Node<Desc>> {
        return next(head, prevNodes.map {
                visitor(it.value)
                if (it.value == finishDesc) return listOf(Node(it.value))
                val descs = it.value.moveAll()
                val newDescs = head.fold(descs) { acc, node ->
                    acc.filter { it != node }
                }
                it.nextNodes = newDescs.map { Node(it) }
                it.nextNodes
            }.fold(mutableListOf()) { acc, nodes ->
            acc.addAll(nodes)
            acc
        })
    }


}
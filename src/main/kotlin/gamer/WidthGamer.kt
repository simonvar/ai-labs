package gamer

import Desc
import Node
import fold
import moveAll

class WidthGamer(
    private val finishDesc: Desc,
    private val visitor: (Desc) -> Unit
) : (Desc) -> Desc {

    override fun invoke(desc: Desc): Desc {
        val head = Node(desc)
        return next(head, listOf(head), mutableListOf()).first().value
    }

    private fun next(head: Node<Desc>, prevNodes: List<Node<Desc>>, listHash: MutableList<Int>): List<Node<Desc>> {
        return next(head, prevNodes.map {
                visitor(it.value)
                listHash.add(it.value.hashCode())
                if (it.value == finishDesc) return listOf(Node(it.value))
                val descs = it.value.moveAll()
                val newDescs = descs.filter { !listHash.contains(it.hashCode()) }
                it.nextNodes = newDescs.map { Node(it) }
                it.nextNodes
            }.fold(mutableListOf()) { acc, nodes ->
            acc.addAll(nodes)
            acc
        }, listHash)
    }


}
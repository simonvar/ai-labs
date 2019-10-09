package gamer

import Desc
import H1
import H2
import Heuristic
import Node
import fold
import moveAll

class HeuristicGamer(
    private val heuristic: Heuristic,
    private val visitor: (Desc) -> Unit
) : (Desc) -> Desc {

//    private lateinit var gHeuristic: Heuristic

    override fun invoke(desc: Desc): Desc {
        val head = Node(desc)
//        gHeuristic = H2(desc)
        return next(head, head, mutableListOf())?.value ?: throw IllegalArgumentException()
    }

    private fun next(head: Node<Desc>, prevNode: Node<Desc>, listHash: MutableList<Int>): Node<Desc>? {
        visitor(prevNode.value)

        listHash.add(prevNode.value.hashCode())

        // Main exit
        if (heuristic(prevNode.value) == 0f) {
            visitor(prevNode.value)
            return prevNode
        }

        val descs = prevNode.value.moveAll()

        val newDescs = descs.filter { !listHash.contains(it.hashCode()) }

        val heuristicDescs = newDescs.sortedBy { heuristic(it) }

        val heuristicNodes = heuristicDescs.map { Node(it) }

        prevNode.nextNodes = heuristicNodes

        if (heuristicNodes.isEmpty()) return null
        return heuristicNodes.asSequence().map { next(head, it, listHash) }.firstOrNull { it != null }
    }

}

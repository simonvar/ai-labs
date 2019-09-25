fun main() {

}



/*
    arg finishDesc, currentDesc
    while (finishDesc != currentDesc) {
        получаем 4 новых desc идя во все стороны
        проверяем 4 новых доски на повторения в предыдущих нодах
    }
 */

//    private fun nextNode(node: Node<Desc>, movement: Desc.Movement): Desc {
//        val value = node.value
//        visitor(value)
//
//        val newDesc = value.move(movement)
//
//        if (newDesc == null) {
//            val nextMovement = movement.nextMovement()
//            return if (nextMovement == null) {
//                nextNode(node, Desc.Movement.RIGHT)
//            } else {
//                // перед созданием ноды проверить на повторы новую доску
//                nextNode(node, nextMovement)
//            }
//        } else {
//            if (newDesc == finishDesc) return newDesc
//            if (checkNode(newDesc, node)) {
//                val nextMovement = movement.nextMovement()
//                return if (nextMovement == null) {
//                    nextNode((node as EndNode).prev, Desc.Movement.RIGHT)
//                } else {
//                    nextNode(node, nextMovement)
//                }
//            }
//            val newNode = EndNode(newDesc, node)
//            return nextNode(newNode, movement)
//        }
//    }

//    private fun checkNode(checkDesc: Desc, node: Node<Desc>): Boolean {
//        return when (node) {
//            is HeadNode -> node.value == checkDesc
//            is EndNode -> node.value == checkDesc || checkNode(checkDesc, node.prev)
//        }
//    }

//    private fun Desc.Movement.nextMovement(): Desc.Movement? {
//        if (this == Desc.Movement.UP) return null
//        val movements = Desc.Movement.values()
//        val movementIndex = movements.indexOf(this)
//        return movements[(movementIndex + 1) % movements.size]
//    }






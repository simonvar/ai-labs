package gamer

import Desc
import Heuristic

class HeuristicGamer(
    private val heuristic: Heuristic,
    private val visitor: (Desc) -> Unit
) : (Desc) -> Desc {

    override fun invoke(desc: Desc): Desc {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

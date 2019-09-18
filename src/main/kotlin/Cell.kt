sealed class Cell {

    object EmptyCell : Cell() {
        override fun toString(): String {
            return "@"
        }
    }


    data class NormalCell(val value: Int) : Cell() {
        override fun toString(): String {
            return value.toString()
        }
    }

}
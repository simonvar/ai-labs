sealed class Node<T>(val value: T)

class HeadNode<T>(value: T) : Node<T>(value)

class EndNode<T>(value: T, val prev: Node<T>) : Node<T>(value)


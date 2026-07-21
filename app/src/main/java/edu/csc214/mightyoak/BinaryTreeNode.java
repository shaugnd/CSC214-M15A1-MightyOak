package edu.csc214.mightyoak;

import java.util.Objects;

/**
 * Represents one node in a generic binary tree.
 *
 * <p>Each node stores one value and may point to a left child, a right child,
 * both children, or no children. Calling {@link #left()} and {@link #right()}
 * allows client code to traverse from a parent node toward the leaves.</p>
 *
 * @param <T> the type of value stored in the node
 */
public final class BinaryTreeNode<T> {
    // Since I am planning to do the Add-on anyway, I just started with that 
    // architecture from the beginning.  It is less messy that way.  

    // This is just a simple tree node class.  The requirements did not seem to
    // be looking for a complete and robust tree management class, so I'm sticking
    // with the basic functions that were expressly identified.   This class does not
    // enforce safe optional traversal or deletion.  Both left() and right() return null
    // if there is no child node.  I have paid special attention to ensuring that the 
    // desired node.left().right().left().value() use case mentioned in the primer
    // works as expected, though.

    private final T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = Objects.requireNonNull(value, "Value cannot be null.");
    }

    public T value() {
        return value;
    }

    public BinaryTreeNode<T> left() {
        return left;
    }

    public BinaryTreeNode<T> right() {
        return right;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = Objects.requireNonNull(left, "Left child cannot be null.");
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = Objects.requireNonNull(right, "Right child cannot be null.");
    }
}

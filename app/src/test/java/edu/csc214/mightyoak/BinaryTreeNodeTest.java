package edu.csc214.mightyoak;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Verifies binary tree node storage, child attachment, traversal, generic type
 * support, and defensive behavior.
 *
 * <p>The test cases follow the ZOMBIE method: Zero, One, Many, Boundary,
 * Interface, and Exception.</p>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BinaryTreeNodeTest {
    @Test
    @Order(1)
    @Tag("Z")
    void zeroNewNodeStoresValueAndStartsWithoutChildren() {
        Squirrel squirrel = new Squirrel("Root");
        BinaryTreeNode<Squirrel> node = new BinaryTreeNode<>(squirrel);

        assertSame(squirrel, node.value());
        assertNull(node.left());
        assertNull(node.right());
    }

    @Test
    @Order(2)
    @Tag("O")
    void oneLeftChildCanBeAttachedAndRetrieved() {
        BinaryTreeNode<Squirrel> root = new BinaryTreeNode<>(new Squirrel("Root"));
        BinaryTreeNode<Squirrel> left = new BinaryTreeNode<>(new Squirrel("Left"));

        root.setLeft(left);

        assertSame(left, root.left());
        assertEquals("Left", root.left().value().getName());
    }

    @Test
    @Order(3)
    @Tag("M")
    void manyBothChildrenCanBeAttachedAndRetrieved() {
        BinaryTreeNode<Squirrel> root = new BinaryTreeNode<>(new Squirrel("Root"));
        BinaryTreeNode<Squirrel> left = new BinaryTreeNode<>(new Squirrel("Left"));
        BinaryTreeNode<Squirrel> right = new BinaryTreeNode<>(new Squirrel("Right"));

        root.setLeft(left);
        root.setRight(right);

        assertSame(left, root.left());
        assertSame(right, root.right());
    }

    @Test
    @Order(4)
    @Tag("M")
    void manyTreeCanBeTraversedThroughSeveralLeftAndRightCalls() {
        BinaryTreeNode<Squirrel> root = new BinaryTreeNode<>(new Squirrel("Root"));
        BinaryTreeNode<Squirrel> left = new BinaryTreeNode<>(new Squirrel("Left"));
        BinaryTreeNode<Squirrel> leftRight = new BinaryTreeNode<>(new Squirrel("Left Right"));
        BinaryTreeNode<Squirrel> leftRightLeft = new BinaryTreeNode<>(new Squirrel("Left Right Left"));
        BinaryTreeNode<Squirrel> target = new BinaryTreeNode<>(new Squirrel("Target"));

        root.setLeft(left);
        left.setRight(leftRight);
        leftRight.setLeft(leftRightLeft);
        leftRightLeft.setLeft(target);

        assertEquals("Target", root.left().right().left().left().value().getName());
    }

    @Test
    @Order(5)
    @Tag("B")
    void boundaryExistingChildCanBeReplaced() {
        BinaryTreeNode<Squirrel> root = new BinaryTreeNode<>(new Squirrel("Root"));
        BinaryTreeNode<Squirrel> firstLeft = new BinaryTreeNode<>(new Squirrel("First Left"));
        BinaryTreeNode<Squirrel> secondLeft = new BinaryTreeNode<>(new Squirrel("Second Left"));

        root.setLeft(firstLeft);
        root.setLeft(secondLeft);

        assertSame(secondLeft, root.left());
        assertEquals("Second Left", root.left().value().getName());
    }

    @Test
    @Order(6)
    @Tag("I")
    void interfaceGenericTreeWorksWithStrings() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("root");
        BinaryTreeNode<String> left = new BinaryTreeNode<>("left");

        root.setLeft(left);

        assertEquals("left", root.left().value());
    }

    @Test
    @Order(7)
    @Tag("I")
    void interfaceGenericTreeWorksWithIntegers() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(20);

        root.setRight(right);

        assertEquals(20, root.right().value());
    }

    @Test
    @Order(8)
    @Tag("E")
    void exceptionNullValueIsRejected() {
        assertThrows(NullPointerException.class, () -> new BinaryTreeNode<String>(null));
    }

    @Test
    @Order(9)
    @Tag("E")
    void exceptionNullLeftChildIsRejected() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("root");

        assertThrows(NullPointerException.class, () -> root.setLeft(null));
    }

    @Test
    @Order(10)
    @Tag("E")
    void exceptionNullRightChildIsRejected() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("root");

        assertThrows(NullPointerException.class, () -> root.setRight(null));
    }
}

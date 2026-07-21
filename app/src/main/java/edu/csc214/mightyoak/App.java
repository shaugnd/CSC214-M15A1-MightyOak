package edu.csc214.mightyoak;

/**
 * Demonstrates a generic binary tree node using squirrel and non-squirrel values.
 */
public class App {
    // This driver shows the required Squirrel tree behavior and the generic
    // binary tree add-on, it is not meant to be comprehensive in any way.
    // The JUnit tests provide the full behavior checks.

    public static void main(String[] args) {
        System.out.println();
        System.out.println("CSC214-M15A1-MightyOak Functionality Demonstrator");
        System.out.println();

        demonstrateSquirrelTree();
        System.out.println();
        demonstrateGenericTrees();

        System.out.println();
        System.out.println("Done.");
    }

    private static void demonstrateSquirrelTree() {
        BinaryTreeNode<Squirrel> root = new BinaryTreeNode<>(new Squirrel("Root"));
        BinaryTreeNode<Squirrel> left = new BinaryTreeNode<>(new Squirrel("Left"));
        BinaryTreeNode<Squirrel> leftRight = new BinaryTreeNode<>(new Squirrel("Left Right"));
        BinaryTreeNode<Squirrel> leftRightLeft = new BinaryTreeNode<>(new Squirrel("Left Right Left"));
        BinaryTreeNode<Squirrel> target = new BinaryTreeNode<>(new Squirrel("Target"));

        root.setLeft(left);
        left.setRight(leftRight);
        leftRight.setLeft(leftRightLeft);
        leftRightLeft.setLeft(target);

        System.out.println("Squirrel Tree");
        System.out.println("  Root squirrel: " + root.value().getName());
        System.out.println("  Traversed squirrel: " + root.left().right().left().left().value().getName());
    }

    private static void demonstrateGenericTrees() {
        BinaryTreeNode<String> wordRoot = new BinaryTreeNode<>("oak");
        BinaryTreeNode<String> wordLeft = new BinaryTreeNode<>("branch");
        wordRoot.setLeft(wordLeft);

        BinaryTreeNode<Integer> numberRoot = new BinaryTreeNode<>(100);
        BinaryTreeNode<Integer> numberRight = new BinaryTreeNode<>(200);
        numberRoot.setRight(numberRight);

        System.out.println("Generic Trees");
        System.out.println("  String tree left value: " + wordRoot.left().value());
        System.out.println("  Integer tree right value: " + numberRoot.right().value());
    }
}

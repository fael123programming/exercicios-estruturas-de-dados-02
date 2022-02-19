package trees.tests;

import trees.binary_tree.balanced.redblack.RedBlackNode;
import trees.binary_tree.balanced.redblack.RedBlackTree;

public class Test2 {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>(200);
        tree.insert(100);
        tree.insert(90);
        tree.insert(250);
        while (!tree.isEmpty())
            tree.delete(tree.getRoot().getData());
        System.out.println(tree.nodes());
        System.out.println("Root: " + tree.getRoot());
        System.out.println("Root left child: " + tree.getRoot().getLeftChild());
        System.out.println("Root right child: " + tree.getRoot().getRightChild());
        tree.print();
    }
}

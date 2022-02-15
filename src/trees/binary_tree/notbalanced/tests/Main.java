package trees.binary_tree.notbalanced.tests;

import trees.binary_tree.notbalanced.classes.*;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);
        System.out.println("Elements: ");
        tree.print();
    }
}

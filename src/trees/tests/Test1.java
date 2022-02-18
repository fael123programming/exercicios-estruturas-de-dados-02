package trees.tests;

import trees.binary_tree.abstractstructure.AbstractBinaryTree;
import trees.binary_tree.balanced.avl.AVLTree;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AbstractBinaryTree<Integer> bst = new AVLTree<>();
        System.out.print("Value: ");
        int value = input.nextInt();
        while (value != -1) {
            bst.insert(value);
            System.out.println("Inserted!");
            System.out.println("-----------------------------------------------");
            System.out.println("Root: " + bst.getRoot());
            System.out.println("Nodes: " + bst.nodes());
            System.out.println("-----------------------------------------------");
            bst.print();
            System.out.println("-----------------------------------------------");
            System.out.print("Value: ");
            value = input.nextInt();
            System.out.println("-----------------------------------------------");
        }
    }
}

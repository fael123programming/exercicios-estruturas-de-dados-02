package trees.tests;

import trees.binary_tree.balanced.redblack.RedBlackNode;
import trees.binary_tree.balanced.redblack.RedBlackTree;
import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int option, value;
        while (true) {
            System.out.println("Testing a red-black tree");
            System.out.println("(1) Insert new value");
            System.out.println("(2) Search a value");
            System.out.println("(3) Tree size");
            System.out.println("(4) Print tree");
            System.out.println("(5) Exit");
            System.out.print("-> ");
            option = Integer.parseInt(reader.readLine().split(" ")[0]);
            switch(option) {
                case 1 -> {
                    System.out.print("Type the new value: ");
                    value = Integer.parseInt(reader.readLine().split(" ")[0]);
                    redBlackTree.insert(value);
                    System.out.println(value + " was inserted");
                }
                case 2 ->  {
                    System.out.print("Type the value to search: ");
                    value = Integer.parseInt(reader.readLine().split(" ")[0]);
                    RedBlackNode<Integer> node = (RedBlackNode<Integer>) redBlackTree.search(value);
                    if (node == null)
                        System.out.println(value + " does not exist in the tree");
                    else {
                        System.out.println("Node: " + node);
                        System.out.println("Parent: " + node.getParent());
                        System.out.println("Left child: " + node.getLeftChild());
                        System.out.println("Right child: " + node.getRightChild());
                        if (node == redBlackTree.getRoot())
                            System.out.println("It's root!");
                    }
                }
                case 3 -> {
                    if (redBlackTree.isEmpty())
                        System.out.println("Tree is empty");
                    else
                        System.out.println("Size: " + redBlackTree.nodes());
                }
                case 4 -> {
                    if (redBlackTree.isEmpty()) {
                        System.out.println("Tree is empty");
                        continue;
                    }
                    System.out.println("Tree printed IN-ORDER");
                    System.out.println("-----------------------------------");
                    redBlackTree.print();
                    System.out.println("-----------------------------------");
                    System.out.println("Root: " + redBlackTree.getRoot());
                    System.out.println("-----------------------------------");
                }
                default -> { return; }
            }
        }
    }
}

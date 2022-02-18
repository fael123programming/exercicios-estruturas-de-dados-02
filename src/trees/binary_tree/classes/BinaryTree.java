package trees.binary_tree.classes;

import trees.binary_tree.abstractstructure.AbstractBinaryTree;
import trees.binary_tree.abstractstructure.AbstractNode;

public class BinaryTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {
    public BinaryTree(T rootData) {
        super(rootData);
    }

    public BinaryTree() {}

    @Override
    protected AbstractNode<T> insertRecursive(AbstractNode<T> node, T data) {
        if (node == null)
            node = this.castDataToNodeImplementation(data);
        else if (data.compareTo(node.getData()) < 0)
            node.setLeftChild(this.insertRecursive(node.getLeftChild(), data));
        else
            node.setRightChild(this.insertRecursive(node.getRightChild(), data));
        return node;
    }

    @Override
    protected AbstractNode<T> castDataToNodeImplementation(T data) {
        return data != null ? new Node<>(data) : null;
    }

    @Override
    protected AbstractNode<T> deleteRecursive(AbstractNode<T> node, T element) {
        if (node == null)
            return null;
        else if (node.getData().compareTo(element) > 0)
            node.setLeftChild(this.deleteRecursive(node.getLeftChild(), element));
        else if (node.getData().compareTo(element) < 0)
            node.setRightChild(this.deleteRecursive(node.getRightChild(), element));
        else { //We have found the wanted element...
            if (node.getLeftChild() == null && node.getRightChild() == null) //It has no children...
                node = null;
             else if (node.getLeftChild() == null) //It has only one child...
                node = node.getRightChild();
             else if (node.getRightChild() == null) //It has only one child...
                 node = node.getLeftChild();
             else { //It has two children...
                 //Find the successor of the element to be deleted.
                 node.setData(this.getMin(node.getRightChild()));
                 node.setRightChild(this.deleteRecursive(node.getRightChild(), node.getData()));
            }
        }
        return node;
    }
}

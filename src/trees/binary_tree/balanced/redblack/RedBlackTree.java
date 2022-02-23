package trees.binary_tree.balanced.redblack;

import trees.binary_tree.abstractstructure.AbstractBinaryTree;
import trees.binary_tree.abstractstructure.AbstractNode;

public class RedBlackTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {
    public RedBlackTree(T data) {
        this.insert(data);
    }

    public RedBlackTree() {}

    /**
     * Inserts new data into the tree maintaining all red-black
     * properties and constraints.
     * @param data the new data to be inserted
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void insert(T data) throws IllegalArgumentException {
        super.checkNull(data);
        RedBlackNode<T> toInsert = new RedBlackNode<>(data);
        this.root = this.insertRecursive(this.root, toInsert);
        super.nodes++;
        this.recolorAndRotate(toInsert);
    }

    @Override
    protected AbstractNode<T> insertRecursive(AbstractNode<T> node, AbstractNode<T> toInsert) {
        if (node == null)
            return toInsert;
        if (toInsert.getData().compareTo(node.getData()) < 0) {
            node.setLeftChild(this.insertRecursive(node.getLeftChild(), toInsert));
            ((RedBlackNode<T>) node.getLeftChild()).setParent((RedBlackNode<T>) node);
        } else {
            node.setRightChild(this.insertRecursive(node.getRightChild(), toInsert));
            ((RedBlackNode<T>) node.getRightChild()).setParent((RedBlackNode<T>) node);
        }
        return node;
    }

    /**
     * Upwards from the given node towards `this.root`.
     * @param node the node where to start recoloring and/or rotating
     */
    private void recolorAndRotate(RedBlackNode<T> node) {
        RedBlackNode<T> treeRoot = (RedBlackNode<T>) this.root;
        if (treeRoot.getColorNumber() == RedBlackNode.RED)
            treeRoot.setColorNumber(RedBlackNode.BLACK);
        RedBlackNode<T> nodeParent = node.getParent();
        if (node == this.root || nodeParent.getColorNumber() == RedBlackNode.BLACK)
            return; //There is nothing to do in this case: until here we encompass the 1st and 2nd case on insertions.
        RedBlackNode<T> nodeGrandParent = nodeParent.getParent();
        RedBlackNode<T> nodeUncle = (RedBlackNode<T>) (nodeParent.isLeftChild() ? nodeGrandParent.getRightChild() : nodeGrandParent.getLeftChild());
        if (nodeUncle != null && nodeUncle.getColorNumber() == RedBlackNode.RED) //Recoloring going upward the tree: it encompasses the 3rd case.
            this.doRecoloring(nodeParent, nodeUncle, nodeGrandParent);
        else if (nodeParent.isLeftChild()) //If nodeUncle is null, it is considered to be black. Then we reach the 4th case.
            this.handleLeftSituations(node, nodeParent, nodeGrandParent);
        else
            this.handleRightSituations(node, nodeParent, nodeGrandParent);
    }

    private void doRecoloring(RedBlackNode<T> nodeParent, RedBlackNode<T> nodeUncle, RedBlackNode<T> nodeGrandParent) {
        nodeParent.flipColor();
        nodeUncle.flipColor();
        nodeGrandParent.flipColor();
        this.recolorAndRotate(nodeGrandParent);
//        After making the recoloring steps, call the method liable for checking when to change color or rotate
//        but now over the grandparent of the node just inserted.
    }

    private void handleLeftSituations(RedBlackNode<T> node, RedBlackNode<T> nodeParent, RedBlackNode<T> nodeGrandParent) {
        if (!node.isLeftChild()) { //If node is a right child, we`ll do a double right rotation.
            this.leftRotation(nodeParent);
            node.flipColor();
        } else
            nodeParent.flipColor();
        nodeGrandParent.flipColor();
        this.rightRotation(nodeGrandParent);
        this.recolorAndRotate(node.isLeftChild() ? nodeParent : nodeGrandParent);
    }

    private void handleRightSituations(RedBlackNode<T> node, RedBlackNode<T> nodeParent, RedBlackNode<T> nodeGrandParent) {
        if (node.isLeftChild()) {
            this.rightRotation(nodeParent);
            node.flipColor();
        } else
            nodeParent.flipColor();
        nodeGrandParent.flipColor();
        this.leftRotation(nodeGrandParent);
        this.recolorAndRotate(node.isLeftChild() ? nodeGrandParent : nodeParent);
    }

    private void leftRotation(RedBlackNode<T> node) {
        RedBlackNode<T> nodeRightChild = (RedBlackNode<T>) node.getRightChild();
        node.setRightChild(nodeRightChild.getLeftChild());
        if (node.getRightChild() != null)
            ((RedBlackNode<T>) node.getRightChild()).setParent(node);
        nodeRightChild.setLeftChild(node);
        nodeRightChild.setParent(node.getParent());
        this.updateChildrenOfParentNode(node, nodeRightChild);
        node.setParent(nodeRightChild);
    }

    private void rightRotation(RedBlackNode<T> node) {
        RedBlackNode<T> nodeLeftChild = (RedBlackNode<T>) node.getLeftChild();
        node.setLeftChild(nodeLeftChild.getRightChild());
        if (node.getLeftChild() != null)
            ((RedBlackNode<T>) node.getLeftChild()).setParent(node);
        nodeLeftChild.setRightChild(node);
        nodeLeftChild.setParent(node.getParent());
        this.updateChildrenOfParentNode(node, nodeLeftChild);
        node.setParent(nodeLeftChild);
    }

    private void updateChildrenOfParentNode(RedBlackNode<T> node, RedBlackNode<T> anotherNode) {
        if (node.getParent() == null)
            this.root = anotherNode;
        else if (node.isLeftChild())
            node.getParent().setLeftChild(anotherNode);
        else
            node.getParent().setRightChild(anotherNode);
    }

    @Override
    public AbstractNode<T> castDataToNodeImplementation(T data) {
        return new RedBlackNode<>(data);
    }

    @Override
    protected AbstractNode<T> deleteRecursive(AbstractNode<T> node, T data) {
        this.deleteHelper((RedBlackNode<T>) this.search(data));
        return node;
    }

    private void deleteHelper(RedBlackNode<T> node) {
        RedBlackNode<T> replacementNode = this.findReplacementOfNode(node);
        boolean fullBlackCase = (replacementNode == null || replacementNode.isBlack()) && node.isBlack();
        RedBlackNode<T> nodeParent = node.getParent();
        if (replacementNode == null) { //Then node is leaf...
            if (node == this.root)
                this.root = null;
            else {
                if (fullBlackCase)
                    this.fixDoubleBlack(node);
                else if(node.getSibling() != null) //Either node or replacementNode is red.
                    node.getSibling().redfy();
                if (node.isLeftChild())
                    node.getParent().setLeftChild(null);
                else
                    node.getParent().setRightChild(null);
            }
            return;
        }
        if (!node.hasLeftChild() || !node.hasRightChild()) { //If node has no children or has only one!
            if (node == this.root) {
                node.setData(replacementNode.getData());
                node.setLeftChild(null);
                node.setRightChild(null);
            } else {
                if (node.isLeftChild())
                    nodeParent.setLeftChild(replacementNode);
                else
                    nodeParent.setRightChild(replacementNode);
                replacementNode.setParent(nodeParent);
                if (fullBlackCase)
                    this.fixDoubleBlack(replacementNode);
                else
                    replacementNode.blackfy();
            }
            return;
        }
//      If we get here it means node has two children. Then we have to swap its value with its successor and call
//      this method once again but now over the replacementNode.
        node.swapData(replacementNode);
        this.deleteHelper(replacementNode);
    }

    private RedBlackNode<T> findMin(RedBlackNode<T> sourceNode) {
        if (sourceNode == null)
            throw new IllegalArgumentException("you have passed me a null pointer");
        if (sourceNode.getLeftChild() == null)
            return sourceNode;
        return this.findMin((RedBlackNode<T>) sourceNode.getLeftChild());
    }

    private RedBlackNode<T> findReplacementOfNode(RedBlackNode<T> node) {
        if (node == null)
            throw new IllegalArgumentException("you have given me a null pointer");
        if (node.isChildless())
            return null;
        if (!node.hasLeftChild())
            return (RedBlackNode<T>) node.getRightChild();
        else if (!node.hasRightChild())
            return (RedBlackNode<T>) node.getLeftChild();
        else //node has two children then choose that one which is considered as its successor.
            return this.findMin((RedBlackNode<T>) node.getRightChild());
    }

    private void fixRedRed(RedBlackNode<T> node) {
        if (node == this.root) {
            node.blackfy();
            return;
        }
        RedBlackNode<T> parent = node.getParent(), grandpa = parent.getParent(), uncle = node.getUncle();
        if (parent.isRed()) {
            if (uncle != null && uncle.isRed()) {
                parent.blackfy();
                uncle.blackfy();
                grandpa.redfy();
                this.fixRedRed(grandpa);
            } else {
                if (parent.isLeftChild()) {
                    if (node.isLeftChild())
                        parent.swapColor(grandpa);
                    else {
                        this.leftRotation(parent);
                        node.swapColor(grandpa);
                    }
                    this.rightRotation(grandpa);
                } else {
                    if (node.isLeftChild()) {
                        this.rightRotation(parent);
                        node.swapColor(grandpa);
                    } else
                        parent.swapColor(grandpa);
                    this.leftRotation(grandpa);
                }
            }
        }
    }

    private void fixDoubleBlack(RedBlackNode<T> node) {
        if (node == this.root)
            return;
        RedBlackNode<T> nodeSibling = node.getSibling(), nodeParent = node.getParent();
        if (nodeSibling == null)
            this.fixDoubleBlack(nodeParent);
        else if (nodeSibling.isRed()) {
            nodeParent.redfy();
            nodeSibling.blackfy();
            if (nodeSibling.isLeftChild())
                this.rightRotation(nodeParent);
            else
                this.leftRotation(nodeParent);
            this.fixDoubleBlack(node);
        } else {
            if (nodeSibling.hasRedChild()) {
                if (nodeSibling.getLeftChild() != null && ((RedBlackNode<T>) nodeSibling.getLeftChild()).isRed()) {
                    if (nodeSibling.isLeftChild()) {
                        ((RedBlackNode<T>) nodeSibling.getLeftChild()).setColorNumber(nodeSibling.getColorNumber());
                        nodeSibling.setColorNumber(nodeParent.getColorNumber());
                        this.rightRotation(nodeParent);
                    } else {
                        ((RedBlackNode<T>) nodeSibling.getLeftChild()).setColorNumber(nodeParent.getColorNumber());
                        this.rightRotation(nodeSibling);
                        this.leftRotation(nodeParent);
                    }
                } else {
                    if (nodeSibling.isLeftChild()) {
                        ((RedBlackNode<T>) nodeSibling.getRightChild()).setColorNumber(nodeParent.getColorNumber());
                        this.leftRotation(nodeSibling);
                        this.rightRotation(nodeParent);
                    } else {
                        ((RedBlackNode<T>) nodeSibling.getRightChild()).setColorNumber(nodeSibling.getColorNumber());
                        nodeSibling.setColorNumber(nodeParent.getColorNumber());
                        this.leftRotation(nodeParent);
                    }
                }
                nodeParent.blackfy();
            } else { //nodeSibling has two black children...
                nodeSibling.redfy();
                if (nodeParent.isBlack())
                    this.fixDoubleBlack(nodeParent);
                else
                    nodeParent.blackfy();
            }
        }
    }
}

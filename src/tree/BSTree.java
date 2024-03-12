package tree;

import node.Node;

public class BSTree {
    public Node root;

    public BSTree(){
        root = null;
    }

    public Node insert(Node node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            node = new Node(key);
            return node;
        }
        // Otherwise, recur down the tree
        if (key < node.key)
            node.leftNode = insert(node.leftNode, key);
        else if (key > node.key)
            node.rightNode = insert(node.rightNode, key);
        
        return node;
    }

    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;
 
        // Key is greater than root's key
        if (root.key < key)
            return search(root.rightNode, key);
 
        // Key is smaller than root's key
        return search(root.leftNode, key);
    }

    @Override
    public String toString(){
        return null;
    }

}

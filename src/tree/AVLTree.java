package tree;
import node.Node;

public class AVLTree {
    public Node root; 

    // A utility function to get the height of the tree 
    int height(Node N) { 
        if (N == null) 
            return 0; 
  
        return N.height; 
    } 
  
    // A utility function to get maximum of two integers 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  
    // A utility function to rightNode rotate subtree rooted with y 
    // See the diagram given above. 
    Node rightNodeRotate(Node y) { 
        Node x = y.leftNode; 
        Node T2 = x.rightNode; 
  
        // Perform rotation 
        x.rightNode = y; 
        y.leftNode = T2; 
  
        // Update heights 
        y.height = max(height(y.leftNode), height(y.rightNode)) + 1; 
        x.height = max(height(x.leftNode), height(x.rightNode)) + 1; 
  
        // Return new root 
        return x; 
    } 
  
    // A utility function to leftNode rotate subtree rooted with x 
    // See the diagram given above. 
    Node leftNodeRotate(Node x) { 
        Node y = x.rightNode; 
        Node T2 = y.leftNode; 
  
        // Perform rotation 
        y.leftNode = x; 
        x.rightNode = T2; 
  
        //  Update heights 
        x.height = max(height(x.leftNode), height(x.rightNode)) + 1; 
        y.height = max(height(y.leftNode), height(y.rightNode)) + 1; 
  
        // Return new root 
        return y; 
    } 
  
    // Get Balance factor of node N 
    int getBalance(Node N) { 
        if (N == null) 
            return 0; 
  
        return height(N.leftNode) - height(N.rightNode); 
    } 
  
    public Node insert(Node node, int key) { 
  
        /* 1.  Perform the normal BST insertion */
        if (node == null) 
            return (new Node(key)); 
  
        if (key < node.key) 
            node.leftNode = insert(node.leftNode, key); 
        else if (key > node.key) 
            node.rightNode = insert(node.rightNode, key); 
        else // Duplicate keys not allowed 
            return node; 
  
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.leftNode), 
                              height(node.rightNode)); 
  
        /* 3. Get the balance factor of this ancestor 
              node to check whether this node became 
              unbalanced */
        int balance = getBalance(node); 
  
        // If this node becomes unbalanced, then there 
        // are 4 cases leftNode leftNode Case 
        if (balance > 1 && key < node.leftNode.key) 
            return rightNodeRotate(node); 
  
        // rightNode rightNode Case 
        if (balance < -1 && key > node.rightNode.key) 
            return leftNodeRotate(node); 
  
        // leftNode rightNode Case 
        if (balance > 1 && key > node.leftNode.key) { 
            node.leftNode = leftNodeRotate(node.leftNode); 
            return rightNodeRotate(node); 
        } 
  
        // rightNode leftNode Case 
        if (balance < -1 && key < node.rightNode.key) { 
            node.rightNode = rightNodeRotate(node.rightNode); 
            return leftNodeRotate(node); 
        } 
  
        /* return the (unchanged) node pointer */
        return node; 
    } 
  
    // A utility function to print preorder traversal 
    // of the tree. 
    // The function also prints height of every node 
    public void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.key + " "); 
            preOrder(node.leftNode); 
            preOrder(node.rightNode); 
        } 
    } 
}
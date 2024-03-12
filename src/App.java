import tree.AVLTree;
import tree.BSTree;

public class App {
    public static void main(String[] args) throws Exception {
        BSTTest();
        System.out.println();
        System.out.println();
        AVLTTest();
    }

    public static void BSTTest(){
        
        BSTree tree = new BSTree();
        tree.root = tree.insert(tree.root, 50);
    
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);
    
        // Key to be found
        var key = 6;
    
        // Searching in a BST
        if (tree.search(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
    
        key = 60;
    
        // Searching in a BST
        if (tree.search(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
    
    }

    public static void AVLTTest(){
        AVLTree tree = new AVLTree(); 
  
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25); 
  
        /* The constructed AVL Tree would be 
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
        */
        System.out.println("Preorder traversal" + 
                        " of constructed tree is : "); 
        tree.preOrder(tree.root); 
    }
}

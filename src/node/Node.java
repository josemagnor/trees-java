package node;

public class Node{
    public Node leftNode;
    public int key;
    public Node rightNode;
    public int height;

    public Node(int key){
        this.key = key;
        this.leftNode = null;
        this.rightNode = null;
        this.height = 1;
    }

    @Override
    public String toString(){
        return " " + this.key;
    }

}

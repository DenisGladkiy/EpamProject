package tree;

/**
 * Created by Denis on 29.03.2018.
 */
public class Node {
    int key;
    boolean color;
    Node left;
    Node right;

    public Node(int key, boolean color){
        this.key = key;
        this.color = color;
    }
}

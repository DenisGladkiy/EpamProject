package tree;

/**
 * Created by Denis on 29.03.2018.
 */
public class RedAndBlackTree {
    private Node root;
    private int size = 0;

    public void add(int key){
        root = add(root, key);
    }

    public Node add(Node node, int key){
        if(node == null){
            size++;
            return new Node(key, false);
        }
        int compare = node.key - key;
        if(compare > 0){
            node.left = add(node.left,key);
        }else if(compare < 0){
            node.right = add(node.right,key);
        }
        return node;
    }

    public Node getNode(int key){return null;}

    public int getKey(Node node){return node.key;}

    public void delete(int key){}

    private void printTree(){
        printElementTree(root,0);
    }

    private void printElementTree(Node node, int level){
        StringBuilder builder = new StringBuilder();
        if(node != null){
            for(int i = 0; i<=level; i++){
                builder.append("-");
            }
            builder.append(String.valueOf(node.key));
            System.out.println(builder);
            level++;
            printElementTree(node.left, level);
            printElementTree(node.right, level);
        }
    }

    public String toString(){
        printTree();
        return "Size = " + String.valueOf(size);
    }
}

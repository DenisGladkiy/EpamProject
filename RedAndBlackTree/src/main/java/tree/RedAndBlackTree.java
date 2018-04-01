package tree;

/**
 * Created by Denis on 29.03.2018.
 */
public class RedAndBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private int size = 0;

    public void add(int key){
        root = add(root, key, false);
        root.color = BLACK;
    }

    private Node add(Node node, int key, boolean flag){
        if(node == null){
            size++;
            return new Node(key, RED);
        }
        if(redColor(node.left) && redColor(node.right)){
            swapColor(node);
        }
        int compare = node.key - key;
        if(compare > 0) {
            node.left = add(node.left, key, false);
            if(redColor(node) && redColor(node.left) && flag){
                node = rotateRight(node);
            }
            if(redColor(node.left) && redColor(node.left.left)){
                node = rotateRight(node);
            }
        }else if(compare < 0){
            node.right = add(node.right,key, true);
            if(redColor(node) && redColor(node.right) && !flag){
                node = rotateLeft(node);
            }
            if(redColor(node.right) && redColor(node.right.right)){
                node = rotateLeft(node);
            }
        }
        return node;
    }

    private Node rotateRight(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = temp.right.color;
        temp.right.color = RED;
        return temp;
    }

    private Node rotateLeft(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = temp.left.color;
        temp.left.color = RED;
        return temp;
    }

    private boolean redColor(Node node){
        if(node == null){
            return BLACK;
        }else{
            return node.color;
        }
    }

    private void swapColor(Node node){
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    public Node getNode(int key){
        if(root == null){
            System.out.println("Дерево пустое");
            return null;
        }
        Node temp = root;
        while(temp != null){
            int compare = temp.key - key;
            if(compare > 0){
                temp = temp.left;
            }else if(compare < 0){
                temp = temp.right;
            }else{
                return temp;
            }
        }
        return null;
    }

    public void delete(int key){
        if(getNode(key) == null){
            return;
        }
        if(!redColor(root.left) && !redColor(root.right)){
            root.color = RED;
        }
        root = delete(root, key);
        if(root != null){
            root.color = BLACK;
        }
        size--;
    }

    private Node delete(Node node, int key){
        if(node.key - key > 0){
            if(!redColor(node.left) && !redColor(node.left.left)){
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, key);
        }else{
            if(redColor(node.left)){
                node = rotateRight(node);
            }
            if(node.key == key && node.right == null){
                return null;
            }
            if(!redColor(node.right) && !redColor(node.right.left)){
                node = moveRedRight(node);
            }
            if(node.key == key){
                Node temp = min(node.right);
                node.key = temp.key;
                node.right = deleteMin(node.right);
            }else{
                node.right = delete(node.right, key);
            }
        }
        return balance(node);
    }

    private Node moveRedLeft(Node node){
        swapColor(node);
        if(redColor(node.right.left)){
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            swapColor(node);
        }
        return node;
    }

    private Node moveRedRight(Node node){
        swapColor(node);
        if(redColor(node.left.left)){
            node = rotateRight(node);
            swapColor(node);
        }
        return node;
    }

    private Node min(Node node){
        if(node.left == null){
            return node;
        }else{
            return min(node.left);
        }
    }

    private Node deleteMin(Node node){
        if(node.left == null){
            return null;
        }
        if(!redColor(node.left) && !redColor(node.left.left)){
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);
        return balance(node);
    }

    private Node balance(Node node){
        if(redColor(node.right)){
            node = rotateLeft(node);
        }
        if(redColor(node.left) && redColor(node.left.left)){
            node = rotateRight(node);
        }
        if(redColor(node.left) && redColor(node.right)){
            swapColor(node);
        }
        return node;
    }

    private void printTree(){
        printElementTree(root,0);
    }

    private void printElementTree(Node node, int level){
        StringBuilder builder = new StringBuilder();
        if(node != null){
            for(int i = 0; i<=level; i++){
                builder.append("-");
            }
            builder.append(String.valueOf(node.key) + " " + (node.color?"red":"black"));
            System.out.println(builder);
            level++;
            printElementTree(node.left, level);
            printElementTree(node.right, level);
        }
    }

    private class Node {
        private int key;
        private boolean color;
        private Node left;
        private Node right;

        public Node(int key, boolean color){
            this.key = key;
            this.color = color;
        }

        @Override
        public String toString(){
            return String.valueOf(key) + (color?"red":"black");
        }
    }

    public String toString(){
        printTree();
        return "Size = " + String.valueOf(size);
    }
}

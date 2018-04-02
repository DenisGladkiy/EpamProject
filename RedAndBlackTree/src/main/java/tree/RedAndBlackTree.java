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
        if(node.key > key) {
            node.left = add(node.left, key, false);
            if(redColor(node) && redColor(node.left) && flag){
                node = rotateRight(node);
            }
            if(redColor(node.left) && redColor(node.left.left)){
                node = rotateRight(node);
            }
        }else if(node.key < key){
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
            if(temp.key > key){
                temp = temp.left;
            }else if(temp.key < key){
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
        root = delete(root, key);
        size--;
    }

    private Node delete(Node node, int key){
        if(node == null){
            return null;
        }
        if(node.key > key){
            node.left = delete(node.left, key);
        }else if(node.key < key){
            node.right = delete(node.right, key);
        }else{
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }
            node.key = min(node.right);
            node.right = delete(node.right, node.key);
        }
        return node;
    }

    private int min(Node node){
        if(node.left == null){
            return node.key;
        }else{
            return min(node.left);
        }
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

import tree.RedAndBlackTree;

/**
 * Created by Denis on 30.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int[] shuffleArr = new int[]{3,6,2,8,9,4,1,7,5};
        RedAndBlackTree tree = new RedAndBlackTree();
        for(int i : arr){
            tree.add(i);
        }
        System.out.println(tree);
        tree = new RedAndBlackTree();
        for(int i : shuffleArr){
            tree.add(i);
        }
        System.out.println(tree);
    }
}

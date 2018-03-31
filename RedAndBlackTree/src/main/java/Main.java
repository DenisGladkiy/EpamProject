import tree.RedAndBlackTree;

/**
 * Created by Denis on 30.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        //int[] shuffleArr = new int[]{3,6,2,8,9,4,1,7,5,11,24,18,10,20};
        int[] shuffleArr = new int[]{35,9,44,19,28,17,75,92,39,95};
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

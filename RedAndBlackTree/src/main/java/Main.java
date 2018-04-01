import tree.RedAndBlackTree;

import java.util.Arrays;

/**
 * Created by Denis on 30.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int[] shuffleArr = new int[]{35,9,44,19,28,17,44,75,92,39,95};
        RedAndBlackTree firstTree = fillTree(arr);
        RedAndBlackTree secondTree = fillTree(shuffleArr);
        secondTree.delete(19);
        System.out.println(secondTree);
        System.out.println(secondTree.isBalanced());
    }

    private static RedAndBlackTree fillTree(int[] arr){
        RedAndBlackTree tree = new RedAndBlackTree();
        for(int i : arr){
            tree.add(i);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(tree);
        return tree;
    }
}

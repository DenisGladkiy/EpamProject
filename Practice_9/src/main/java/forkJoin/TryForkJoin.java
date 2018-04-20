package forkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Denis on 20.04.2018.
 */
public class TryForkJoin {
    private static int size = 1_000_000;
    private static final int THREADS_NUMBER = 8;
    private static int[] array;

    public static void main(String[] args) {
        array = arrayInit(size);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREADS_NUMBER);
        long computedSum = forkJoinPool.invoke(new RecursiveSum(0, size-1));
        long sum = Arrays.stream(array).sum();
        System.out.println("Computed by fork = " + computedSum + " Expected = " + sum);
    }

    static class RecursiveSum extends RecursiveTask<Long>{
        int from, to;

        public RecursiveSum(int from, int to){
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to - from) < 20){
                long localSum = 0;
                for(int i = from; i <= to; i++){
                    localSum += array[i];
                }
                System.out.println("Local sum = " + localSum + " for range " + from + " - " + to);
                return localSum;
            }else{
                int mid = (from + to) / 2;
                RecursiveSum firstHalf = new RecursiveSum(from, mid);
                firstHalf.fork();
                RecursiveSum secondHalf = new RecursiveSum(mid + 1, to);
                long resultSecond = secondHalf.compute();
                return firstHalf.join() + resultSecond;
            }
        }
    }

    private static int[] arrayInit(int size){
        int[] arr = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(100);
        }
        return arr;
    }
}

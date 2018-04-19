package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Denis on 19.04.2018.
 */
public class MapSynchro {

    private Map<Integer, Integer> testMap;
    private List<Integer> keys;
    private CyclicBarrier barrier;
    private long startTime;
    private int totalTime;
    private int executions;

    public MapSynchro(Map<Integer, Integer> testMap){
        this.testMap = testMap;
        initialize();
    }

    public void startMapTest() {
        for(int i = 0; i < 1000; i +=5){
            startTime = System.currentTimeMillis();
            initWriter(i, i+1, i+2, i+3, i+4).start();
            initReader(i, i+1, i+2, i+3, i+4).start();
        }
        executions ++;
    }

    private void initialize(){
        keys = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            keys.add(i);
        }
        initBerrier();
    }

    private synchronized void write(Integer key){
        testMap.put(key, key);
        notify();
    }

    private synchronized Integer read(Integer key){
        while(!testMap.containsKey(key)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return testMap.get(key);
    }

    private Thread initWriter(Integer... subKeys) {
        return new Thread(() -> {
            for (int i : subKeys) {
                write(i);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
    }

    private Thread initReader(Integer... subKeys){
        return new Thread(()-> {
            for (int i : subKeys){
                read(i);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
    }

    private void initBerrier(){
        barrier = new CyclicBarrier(400, new Runnable() {
            @Override
            public void run() {
                totalTime += System.currentTimeMillis() - startTime;
            }
        });
    }

    public int getAverageTime(){
        return totalTime/executions;
    }
}

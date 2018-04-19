package map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Denis on 19.04.2018.
 */
public class Main {
    private static MapSynchro normalMap;
    private static MapSynchro concurrentMap;

    public static void main(String[] args) {
        initMaps();
        executeTest();
    }

    private static void initMaps(){
        normalMap = new MapSynchro(new HashMap<>());
        concurrentMap = new MapSynchro(new ConcurrentHashMap<>());
    }

    private static void executeTest(){
        for(int i = 0; i < 10; i++) {
            normalMap.startMapTest();
            concurrentMap.startMapTest();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("HashMap time = " + normalMap.getAverageTime());
        System.out.println("ConcurrentMap time = " + concurrentMap.getAverageTime());
    }
}

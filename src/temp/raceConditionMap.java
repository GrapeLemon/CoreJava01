package temp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class raceConditionMap {
    public static Map<String,Integer> maps =  new ConcurrentHashMap<>();
    public static int i = 0;

    public static void add(){
        maps.put("1",i++);
        System.out.println(Thread.currentThread().toString() + maps.get("1"));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        add();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}


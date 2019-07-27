package temp;

public class MutilThreadThread {
    public static int num = 0;
    public static void add(){
        num++;
        System.out.println(Thread.currentThread().toString() + num);
        sub();
    }
    public static void sub(){
        num--;
        System.out.println(Thread.currentThread().toString() + num);
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

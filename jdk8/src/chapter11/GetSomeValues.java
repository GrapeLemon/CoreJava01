package chapter11;

/**
 * @author wx-li
 * @date 2019/10/22-9:19
 **/
public class GetSomeValues {
    public static void main(String[] args) {
        // 应该是 2 , 不然就是 4
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

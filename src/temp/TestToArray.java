package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wx-li
 * @date 2019/10/17-9:55
 **/
public class TestToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        // 够容量的话就不会创建新的数组,否则会创建新的数组
        String[] strs = new String[3];
        // 可以看得出原数组的内容被覆盖了...
//        strs[0] = "a";
//        strs[1] = "b";
//        strs[2] = "c";
        String[] strs1 = list.toArray(strs);
        for (String str : strs) {
            System.out.println(str);
        }
        System.out.println("------------");
        for (String str : strs1) {
            System.out.println(str);
        }
        System.out.println(strs);
        System.out.println(strs1);
        System.out.println(Arrays.equals(strs, strs1));
    }
}

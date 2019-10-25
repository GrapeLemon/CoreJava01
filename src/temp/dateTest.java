package temp;

import java.text.SimpleDateFormat;

/**
 * @author wx-li
 * @date 2019/10/17-15:39
 **/
public class dateTest {
    public static void main(String[] args) {
        Integer date = Integer.parseInt(
                new SimpleDateFormat("yyyyMMdd").
                        format(System.currentTimeMillis()));
        System.out.println(date);
    }
}

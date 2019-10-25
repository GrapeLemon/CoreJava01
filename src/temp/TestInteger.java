//package temp;
//
//import java.util.Objects;
//
///**
// * @author wx-li
// * @date 2019/10/15-10:19
// **/
//public class TestInteger {
//    public static void main(String[] args) {
//        // 如果是这样写的话输出的就是false
//        Integer i1 = new Integer(1);
//        Integer i2 = new Integer(1);
//
//        // 这样写也是false
//        Integer i3 = 1;
//        Integer i4 = new Integer(1);
//
//        // 这样写就是true了
//        Integer i3 = 1;
//        Integer i4 = 1;
//
//        // 推测原理应该是 1 是字面量, i3 和 i4都指向同一个字面量的地址,所以他们的地址是相同的,
//        // 其他的写法跟这个情况不同,所以指向也不同
//
//        System.out.println(i1 == i2);
//        System.out.println(i1.equals(i2));
//        System.out.println(Objects.equals(i1, i2));
//    }
//}

package KeyClass;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        /**
         *  构造方法，分配 Date 对象并用当前时间初始化此对象，以表示分配它的时间（精确到毫秒）。
         */
        Date date = new Date();

        /**
         *  构造方法，分配 Date 对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，即 1970 年 1 月 1 日 00:00:00 GMT）以来的指定毫秒数
         */
        Date date1 = new Date(1);

        /**
         *  测试此日期是否在指定日期之后
         */
        date.after(date1);

        /**
         *  测试此日期是否在指定日期之前
         */
        date.before(date1);

        /**
         *  返回此对象的副本    (两者之间已经没有了关系，因为相当于了创建多了一个新的对象，而不是把引用赋值给变量)
         */
        Date date2 = (Date)date.clone();

        /**
         *  比较两个日期的顺序
         */
        System.out.println(date.compareTo(date1));

        /**
         *  返回自1970年1月1日00:00:00 GMT以来此Date对象标识的毫秒数
         */
        date.getTime();

        /**
         *  返回此对象的哈希码值（讲道理，在java中的这个hash起的是什么作用，关键是它的原理是什么？感觉好多地方都要用到这个hash）
         */
        date.hashCode();

        /**
         * 设置此Date对象,以表示 1970 年 1 月 1 日 00:00:00 GMT 以后 time 毫秒的时间点。
         */
        date.setTime(2);

        /**
         *  把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy
         */
        date.toString();
    }
}

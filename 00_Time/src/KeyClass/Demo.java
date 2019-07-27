package KeyClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {
    public static void main(String[] args) {
        /**
         *  表示特定的瞬间，可以精确到毫秒。
         *  从jdk1.1开始，应该使用Calendar类实现日期(年月日时分秒) 和时间(时间戳应该是) 字段之间转换
         *  使用DateFormat类来格式化和分析日期字符串。Date中的把日期解释为年月日时分秒值的方法已废弃。
         */
        Date date;

        /**
         *  DateFormat是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并分析日期或时间。
         *  日期/时间格式化子类(如 SimpleDateFormat)运行进行格式化（也就是日期 -> String）、分析(String -> 日期) 和标准化。
         *  将日期表示为Date对象，或者表示为从GMT（格林尼治标准时间）1970年1月1号00:00:00这一刻开始的毫秒数
         */
        DateFormat dateFormat;

        /**
         *  SimpleDateFormat是一个以与语言环境相关的方式来格式化和分析日期的具体类。它允许进行格式化(Date -> String)
         *  分析(String -> Date)  和规范化
         *  SimpleDateFormat使得我们可以选择任何用户定义的日期-时间格式的模式。但是，仍然建议通过DateFormat 中的
         *  getTimeInstance、getDateInstance 或 getDateTimeInstance 来创建日期-时间格式化程序
         */
        SimpleDateFormat simpleDateFormat;

        /**
         *  Calendar是一个抽象类，它为特定瞬间与一组诸如 YEAR     MONTH   DAY_OF_MONTH    HOUR    等日历字段之间的转换提供了一些方法，
         *  并为操作日历字段（例如获得下星期的日期）提供了一些方法。瞬间可用毫秒值来表示，
         *  它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000，格里高利历）的偏移量。
         */
        Calendar calendar;

        /**
         *  GregorianCalendar  是 Calendar 的一个具体子类，提供了世界上大多数国家使用的标准日历系统
         *
         */
        GregorianCalendar gregorianCalendar;




    }
}

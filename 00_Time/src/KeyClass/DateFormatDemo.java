package KeyClass;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) {
        //要格式化一个当前语言环境下的日期，可使用某个静态工厂方法：
        Date myDate = new Date();
        String myString = DateFormat.getDateInstance(DateFormat.LONG).format(myDate);
        System.out.println("myString = " + myString);
        }
    }

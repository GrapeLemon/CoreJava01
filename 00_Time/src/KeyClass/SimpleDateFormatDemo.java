package KeyClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static final String myDate = "yyyy-MM-dd HH:mm";
    public static void main(String args[]) throws ParseException {
        //讲道理，玩好这个SimpleDateFormat就已经差不多了...
        DateFormat dateFormat = new SimpleDateFormat(myDate);
        Date now = new Date();
        System.out.println(dateFormat.format(now));
        System.out.println(dateFormat.parse(dateFormat.format(now)).getTime());
    }
}

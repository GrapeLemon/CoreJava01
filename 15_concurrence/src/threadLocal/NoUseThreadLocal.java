package threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoUseThreadLocal {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void printDate(){
        String dateStamp = dateFormat.format(new Date());
        System.out.println("dateStamp = " + dateStamp);
    }

}

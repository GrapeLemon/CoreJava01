package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017,1,4);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int dayOfMonth = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int length = localDate.lengthOfMonth();
        boolean leapYear = localDate.isLeapYear();
    }
}

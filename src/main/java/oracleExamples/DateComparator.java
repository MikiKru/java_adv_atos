package oracleExamples;

import java.time.*;
import java.util.Calendar;

public class DateComparator {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2016, Month.JUNE, 1);
        LocalDateTime date2 = LocalDateTime.of(2017, Month.JANUARY, 1, 1, 1);
        LocalDateTime ldt1 = LocalDateTime.of(
                date1.getYear(),
                date1.getMonth().getValue(),
                date1.getDayOfMonth(),0,0,0);
        //        Period p = Period.between(ldt1, date2);
                Duration p = Duration.between(ldt1, date2);


//        System.out.print(p.getYear() + ":" + p.getMonths() + ":" + p.getDays());

    }
}

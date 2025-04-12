package Interfaces;

import java.time.LocalDate;
import java.util.Date;

public interface DataTime {
    Date getTimeNow();
    String format(Date date);
    LocalDate createValidDeadLine(int day, int month, int year);
}

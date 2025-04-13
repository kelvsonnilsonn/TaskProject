package Interfaces;

import java.time.LocalDate;
import java.util.Date;

public interface DataTime {
    String getTimeNow();
    LocalDate createValidDeadLine(int day, int month, int year);
}

package Interfaces;

import java.time.LocalDate;

public interface DataTimeInterface {
    String getTimeNow();
    LocalDate createValidDeadLine(int day, int month, int year);
}

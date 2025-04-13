package Util;

import Interfaces.DataTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataTimeService implements DataTime {

    @Override
    public String getTimeNow(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return time.format(formatter);
    }

    @Override
    public LocalDate createValidDeadLine(int day, int month, int year){
        LocalDate dateToCheck = LocalDate.of(year, month, day);
        if(dateToCheck.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data está no passado.");
        }
        return dateToCheck;
    }
}

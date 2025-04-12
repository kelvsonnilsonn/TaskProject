package Util;

import Interfaces.DataTime;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public class DataTimeService implements DataTime {
    @Override
    public Date getTimeNow(){
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }
    @Override
    public String format(Date data){
        DateFormat dayFormatter = DateFormat.getDateInstance();
        DateFormat timeFormatter = DateFormat.getTimeInstance();

        return String.format("DATA: %s - HORÁRIO: %s",
                dayFormatter.format(data), timeFormatter.format(data));
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

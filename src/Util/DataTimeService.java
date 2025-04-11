package Util;

import Interfaces.DataTime;

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

}

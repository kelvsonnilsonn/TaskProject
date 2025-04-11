package Util;

import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;

public class TaskDateFormatter {
    public String format(Calendar calendar){
        Date date = calendar.getTime();

        DateFormat dayFormatter = DateFormat.getDateInstance();
        DateFormat timeFormatter = DateFormat.getTimeInstance();

        return String.format("DATA: %s\nHORÁRIO: %s",
                dayFormatter.format(date),
                timeFormatter.format(date));
    }
}

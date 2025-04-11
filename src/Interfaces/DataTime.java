package Interfaces;

import java.util.Date;

public interface DataTime {
    Date getTimeNow();
    String format(Date date);
}

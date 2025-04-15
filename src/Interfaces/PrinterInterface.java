package Interfaces;

import java.util.List;
import model.Task;

public interface PrinterInterface {
    void printTasks(List<Task> taskList);
    void printAlertMissingTime(Task task, int days);
}

package Util;

import Interfaces.ManagerInterface;
import Interfaces.PrinterInterface;
import Interfaces.ReminderInterface;
import UI.TaskPrinter;
import model.Task;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.List;

public class ReminderService implements ReminderInterface {

    private final PrinterInterface printer;

    public ReminderService(PrinterInterface printer){
        this.printer = printer;
    }
    @Override
    public void reminderTasks(List<Task> taskList){
        for(Task task : taskList){
            long days = ChronoUnit.DAYS.between(LocalDate.now(), task.getDeadline());
            if(days <= 30){
                printer.printAlertMissingTime(task, (int) days);
            }
        }
    }
}

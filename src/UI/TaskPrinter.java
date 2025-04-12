package UI;

import Interfaces.Printer;
import model.Task;

import java.util.List;

public class TaskPrinter implements Printer {
    @Override
    public void printTasks(List<Task> taskList){
        for(Task t : taskList){
            System.out.println(t);
        }
    }
}


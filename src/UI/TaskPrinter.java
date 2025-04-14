package UI;

import Interfaces.Printer;
import model.Task;

import java.util.List;

public class TaskPrinter implements Printer {
    @Override
    public void printTasks(List<Task> taskList){
        taskList.forEach(System.out::println);
    }
}


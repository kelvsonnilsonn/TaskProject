package UI;

import Interfaces.Printer;
import model.Task;

import java.util.List;

public class TaskPrinter implements Printer {
    @Override
    public void printTasks(List<Task> taskList){
        taskList.forEach(task -> System.out.printf(" - %s Prioridade: %s, Tag: %s\n",
                task.getName(),
                task.getPriority(),
                task.getTag())
        );
    }
}


package UI;

import Interfaces.PrinterInterface;
import model.Task;

import java.util.List;

public class TaskPrinter implements PrinterInterface {
    @Override
    public void printTasks(List<Task> taskList){
        taskList.forEach(System.out::println);
    }

    @Override
    public void printAlertMissingTime(Task task, int days){
        System.out.printf("Tarefa : %s : vence em %d dias. Faça-a\n", task.getName(), days);
    }
}


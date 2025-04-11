package Util;

import Interfaces.Logger;
import model.Task;

public class TaskLogger implements Logger {
    @Override
    public void createdTaskLog(Task task){
        System.out.printf("[LOG] %s : Criado - %s\n", task.getDate(), task.getName());
    }

    @Override
    public void deletedTaskLog(Task task){
        System.out.printf("[LOG] %s : Deletado - %s\n", task.getDate(), task.getName());
    }

    @Override
    public void completedTaskLog(Task task){
        System.out.printf("[LOG] %s : Completada! - %s\n", task.getDate(), task.getName());
    }
}

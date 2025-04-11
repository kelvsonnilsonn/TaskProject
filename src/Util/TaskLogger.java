package Util;

import Interfaces.Logger;
import model.Task;

public class TaskLogger implements Logger {
    @Override
    public void createdTaskLog(Task task, String data){
        System.out.printf("[LOG] %s : Criado - %s\n", data, task);
    }

    @Override
    public void deletedTaskLog(Task task, String data){
        System.out.printf("[LOG] %s : Deletado - %s\n", data, task.getName());
    }

    @Override
    public void completedTaskLog(Task task, String data){
        System.out.printf("[LOG] %s : Completada! - %s\n", data, task.getName());
    }
}

package Util;

import Interfaces.DataTime;
import Interfaces.Logger;
import model.Task;

public class TaskLogger implements Logger {
    @Override
    public void createdTaskLog(Task task, DataTime time){
        System.out.printf("[LOG] %s : Criado - %s\n", time, task.getName());
    }

    @Override
    public void deletedTaskLog(Task task, DataTime time){
        System.out.printf("[LOG] %s : Deletado - %s\n", time, task.getName());
    }

    @Override
    public void completedTaskLog(Task task, DataTime time){
        System.out.printf("[LOG] %s : Completada! - %s\n", time, task.getName());
    }
}

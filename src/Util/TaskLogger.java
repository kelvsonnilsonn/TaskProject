package Util;

import Interfaces.Logger;
import model.Task;

public class TaskLogger implements Logger {
    @Override
    public void createdTaskLog(Task task, String data){
        ;
    }

    @Override
    public void deletedTaskLog(Task task, String data){
        System.out.println("Deletado log!");
    }

    @Override
    public void completedTaskLog(Task task, String data){
        System.out.println("Completado log!");
    }
}

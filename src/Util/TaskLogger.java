package Util;

import Interfaces.DataTime;
import Interfaces.Logger;

import java.io.IOException;
import java.io.FileWriter;

import model.Task;

public class TaskLogger implements Logger {
    private static final String LOG_FILE = "Log.txt";

    @Override
    public void createdTaskLog(Task task, DataTime time){
        try(FileWriter writer = new FileWriter(LOG_FILE, true)){
            // (...)
        } catch (Exception e){
            System.err.println("Creating log error. " + e.getMessage());
        }
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

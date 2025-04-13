package Util;

import Interfaces.DataTime;
import Interfaces.Logger;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

import model.Task;

public class TaskLogger implements Logger {
    private static final String LOG_FILE = "Log.txt";

    private final PrintWriter writer;
    private final DataTime timer;

    public TaskLogger(PrintWriter writer, DataTime timer) {
        this.writer = writer;
        this.timer = timer;
    }

    @Override
    public void createdTaskLog(Task task){
        logAction(task, timer.getTimeNow(), "CREATED");
    }

    @Override
    public void deletedTaskLog(Task task){
        logAction(task, timer.getTimeNow(), "DELETED");
    }

    @Override
    public void completedTaskLog(Task task){
        logAction(task, timer.getTimeNow(), "COMPLETE");
    }

    @Override
    public void close(){
        writer.close();
    }

    private void logAction(Task task, String time, String action){
        writer.println(formattedMessageToLog(task, time, action));
    }

    private String formattedMessageToLog(Task task, String time, String type){
        StringBuilder message = new StringBuilder();

        message.append("[LOG : " + time + "] ").append(type + " -> ")
                .append("Task : " + task.getName()).append(" | ")
                .append("Objetivo : " + task.getValue()).append(" | ")
                .append("Prazo : " + task.getDeadlineFormatted());

        return message.toString();
    }
}

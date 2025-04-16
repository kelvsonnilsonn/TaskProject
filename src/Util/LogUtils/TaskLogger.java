package Util.LogUtils;

import Interfaces.DataTimeInterface;
import Interfaces.LoggerInterface;

import java.io.PrintWriter;

import model.Task;

public class TaskLogger implements LoggerInterface {

    private final PrintWriter writer;
    private final DataTimeInterface timer;

    public TaskLogger(PrintWriter writer, DataTimeInterface timer) {
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

        message.append("[LOG : " + time + "] ").append(" | ")
                .append(type).append(" | ")
                .append("Task : " + task.getName()).append(" | ")
                .append("Objetivo : " + task.getObjective()).append(" | ")
                .append("Prioridade : " + task.getPriority()).append(" | ")
                .append("Tag : ").append(String.join(", ", task.getTag())).append(" | ")
                .append("Status : ").append(task.getStatus());
        if(!type.equals("COMPLETE")) message.append(" | ").append("Prazo : ").append(task.getDeadlineFormatted());

        return message.toString();
    }
}

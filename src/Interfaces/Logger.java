package Interfaces;

import model.Task;

import java.util.Date;

public interface Logger {
    void createdTaskLog(Task task);
    void deletedTaskLog(Task task);
    void completedTaskLog(Task task);
    void close();
}

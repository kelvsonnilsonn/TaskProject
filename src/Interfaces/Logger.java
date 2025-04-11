package Interfaces;

import model.Task;

public interface Logger {
    void createdTaskLog(Task task, String data);
    void deletedTaskLog(Task task, String data);
    void completedTaskLog(Task task, String data);
}

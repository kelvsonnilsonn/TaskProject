package Interfaces;

import model.Task;

public interface Logger {
    void createdTaskLog(Task task);
    void deletedTaskLog(Task task);
    void completedTaskLog(Task task);
}

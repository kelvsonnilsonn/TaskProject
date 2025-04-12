package Interfaces;

import model.Task;

public interface Logger {
    void createdTaskLog(Task task, DataTime time);
    void deletedTaskLog(Task task, DataTime time);
    void completedTaskLog(Task task, DataTime time);
}

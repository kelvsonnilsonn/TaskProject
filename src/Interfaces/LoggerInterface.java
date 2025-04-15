package Interfaces;

import model.Task;

public interface LoggerInterface {
    void createdTaskLog(Task task);
    void deletedTaskLog(Task task);
    void completedTaskLog(Task task);
    void close();
}

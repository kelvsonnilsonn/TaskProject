package Interfaces;

import model.Priority;

public interface Manager {
    void createTask(String taskName, String data, Priority priority);
    void deleteTask(String taskName);
    void getAllTasks();
    void findTaskByPriority(Priority priority);
}

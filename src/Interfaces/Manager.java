package Interfaces;

import Enums.Priority;
import model.Task;

import java.util.List;

public interface Manager {
    void createTask(String taskName, String data,
                    Priority priority, String tag,
                    int day, int month, int year, String type);
    void completeTask(String taskName);
    void deleteTask(String taskName);
    void addTagToTask(String task, String newTag);
    void uploadTaskFromData(List<Task> uploadedTask);

    Task findTaskByName(String name);
    List<Task> getAllTasks();
    List<Task> getAllTasksByTag(String tag);
    List<Task> getTasksFilteredByPriority(Priority priority);

}

package Interfaces;

import model.Priority;
import model.Task;

import java.time.LocalDate;
import java.util.List;

public interface Manager {
    void createTask(String taskName, String data,
                    Priority priority, String tag,
                    int day, int month, int year);
    void completeTask(String taskName);
    void deleteTask(String taskName);
    void addTagToTask(String task, String newTag);
    void uploadTaskFromData(List<Task> uploadedTask);

    List<Task> getAllTasks();
    List<Task> getAllTasksByTag(String tag);
    List<Task> getTasksFilteredByPriority(Priority priority);

}

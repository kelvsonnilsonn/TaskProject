package Interfaces;

import Enums.Priority;
import model.Task;

import java.time.LocalDate;
import java.util.List;

public interface ManagerInterface {
    void createTask(String taskName, String data,
                    Priority priority, String tag,
                    int day, int month, int year, String type);
    void deleteTask(String taskName, String type);
    void addTagToTask(String task, String newTag);
    void uploadTaskFromData(List<Task> uploadedTask);

    Task findTaskByName(String name);
    List<Task> getAllTasks();
    List<Task> getAllTasksByTag(String tag);
    List<Task> getTasksFilteredByPriority(Priority priority);
    List<Task> getTaskFilteredByIntervals(LocalDate start, LocalDate end);
    List<Task> getTaskFilteredByStatus(String status);

}

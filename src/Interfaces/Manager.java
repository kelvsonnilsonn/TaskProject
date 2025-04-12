package Interfaces;

import model.Priority;
import model.Task;

import java.time.LocalDate;
import java.util.List;

public interface Manager {
    void createTask(String taskName, String data,
                    Priority priority, String tag,
                    int day, int month, int year);

    void deleteTask(String taskName);

    List<Task> getAllTasks();

    List<Task> getAllTasksByTag(String tag);

    void addTagToTask(String task, String newTag);

    List<Task> getTasksFilteredByPriority(Priority priority);
}

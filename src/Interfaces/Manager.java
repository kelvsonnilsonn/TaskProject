package Interfaces;

import model.Priority;
import model.Task;
import java.util.List;

public interface Manager {
    void createTask(String taskName, String data, Priority priority, String tag);
    void deleteTask(String taskName);
    List<Task> getAllTasks();
    List<Task> getAllTasksByTag(String tag);
    void addTagToTask(String task, String newTag);
    List<Task> getTasksFilteredByPriority(Priority priority);
}

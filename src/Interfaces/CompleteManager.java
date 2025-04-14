package Interfaces;

import model.Task;
import java.util.List;

public interface CompleteManager {
    void addCompletedTask(Task task);

    List<Task> getCompletedTasks();
}

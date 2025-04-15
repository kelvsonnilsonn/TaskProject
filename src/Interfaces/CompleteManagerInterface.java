package Interfaces;

import model.Task;
import java.util.List;

public interface CompleteManagerInterface {
    void addCompletedTask(Task task);

    List<Task> getCompletedTasks();
}

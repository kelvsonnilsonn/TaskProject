package Services;

import Enums.TaskStatus;
import Interfaces.CompleteManagerInterface;
import Interfaces.LoggerInterface;
import Interfaces.ManagerInterface;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class CompletedTaskManager implements CompleteManagerInterface {
    private final List<Task> completedTasks = new ArrayList<>();

    private final LoggerInterface logger;
    private final ManagerInterface taskManager;

    public CompletedTaskManager(LoggerInterface logger, ManagerInterface taskManager){
        this.logger = logger;
        this.taskManager = taskManager;
    }

    @Override
    public void addCompletedTask(Task task){
        if(task == null){
            throw new IllegalArgumentException("Tarefa não encontrada ao completar.");
        } else {
            task.updateStatus(TaskStatus.COMPLETED);
            completedTasks.add(task);
            taskManager.deleteTask(task.getName(), "DELETED");
            logger.completedTaskLog(task);
        }
    }

    @Override
    public List<Task> getCompletedTasks() {
        return new ArrayList<>(completedTasks);
    }
}

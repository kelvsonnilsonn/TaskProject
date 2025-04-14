package Services;

import Interfaces.CompleteManager;
import Interfaces.Logger;
import Interfaces.Manager;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class CompletedTaskManager implements CompleteManager {
    private List<Task> completedTasks = new ArrayList<>();

    private Logger logger;
    private Manager taskManager;

    public CompletedTaskManager(Logger logger, Manager taskManager){
        this.logger = logger;
        this.taskManager = taskManager;
    }

    @Override
    public void addCompletedTask(Task task){
        if(task == null){
            throw new IllegalArgumentException("Tarefa não encontrada ao completar.");
        } else {
            completedTasks.add(task);
            taskManager.deleteTask(task.getName());
            logger.completedTaskLog(task);
        }
    }

    @Override
    public List<Task> getCompletedTasks() {
        return new ArrayList<>(completedTasks);
    }
}

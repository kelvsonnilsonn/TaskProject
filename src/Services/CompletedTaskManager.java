package Services;

import Interfaces.CompleteManagerInterface;
import Interfaces.LoggerInterface;
import Interfaces.ManagerInterface;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class CompletedTaskManager implements CompleteManagerInterface {
    private List<Task> completedTasks = new ArrayList<>();

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
            task.setStatus(!task.isOverDue() ? "Feita" : "Feita com atraso.");
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

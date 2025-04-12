package Services;

import Interfaces.DataTime;
import Interfaces.Logger;
import Interfaces.Manager;
import model.Priority;
import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager implements Manager {

    private final List<Task> taskList = new ArrayList<>();

    private final DataTime dataService;
    private final Logger logger;

    public TaskManager(DataTime dataService, Logger logger){
        this.dataService = dataService;
        this.logger = logger;
    }

    @Override
    public void createTask(String taskName, String body, Priority priority){  // criar task

        if(findTaskByName(taskName) != null){
            throw new IllegalArgumentException("Tarefa '" + taskName + "' já existe.");
        } else {
            String formatedData = dataService.format(dataService.getTimeNow()); // formata a data

            Task task = new Task(taskName,
                    body,
                    formatedData,
                    false,
                    priority);
            taskList.add(task); // adiciona a task à lista

            // logger.createdTaskLog(task); // log
        }
    }

    @Override
    public void deleteTask(String taskName) {
        Task taskFound = taskList.stream()
                .filter(task -> task.getName().equals(taskName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));
        taskList.remove(taskFound);

        // logger.deletedTaskLog(taskFound);
    }

    private Task findTaskByName(String name){
        return taskList.stream()
                .filter(task -> task.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void getAllTasks(){
        for(Task t : taskList){
            System.out.print(t + "\n");
        }
    }
    @Override
    public void findTaskByPriority(Priority priority){
        List<Task> tasksFound = filterByPriority(priority);

        for(Task t : tasksFound){
            System.out.print(t + "\n");
        }
    }

    private List<Task> filterByPriority(Priority priority){
        return taskList.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }
}

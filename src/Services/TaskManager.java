package Services;

import Interfaces.DataTime;
import Interfaces.Logger;
import Interfaces.Manager;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Manager {

    private final List<Task> taskList = new ArrayList<>();

    private final DataTime dataService;
    private final Logger logger;

    public TaskManager(DataTime dataService, Logger logger){
        this.dataService = dataService;
        this.logger = logger;
    }

    @Override
    public void createTask(String taskName, String body){  // criar task

        String formatedData = dataService.format(dataService.getTimeNow()); // formata a data

        taskList.add(new Task(taskName, body, formatedData, false)); // cria a task
    }

    @Override
    public void deleteTask(String taskName){
        ;
    }
}

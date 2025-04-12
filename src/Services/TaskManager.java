package Services;

import Interfaces.DataTime;
import Interfaces.Logger;
import Interfaces.Manager;
import Interfaces.Validate;
import model.Priority;
import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager implements Manager {

    private final List<Task> taskList = new ArrayList<>();

    private final DataTime dataService;
    private final Logger logger;
    private final Validate validate;

    public TaskManager(DataTime dataService, Logger logger, Validate validate){
        this.dataService = dataService;
        this.logger = logger;
        this.validate = validate;
    }

    @Override
    public void createTask(String taskName, String body,
                           Priority priority, String tag,
                           int day, int month, int year){  // criar task

        taskName = validate.requireNonEmpty(taskName, "CREATE TASK - NAME");
        body = validate.requireNonEmpty(body, "CREATE TASK - BODY");
        LocalDate validatedDeadline = dataService.createValidDeadLine(day, month, year);

        if(findTaskByName(taskName) != null){
            throw new IllegalArgumentException("[CREATE TASK - ERROR] Tarefa '" + taskName + "' já existe.");
        } else {
            Task task = new Task(taskName,
                    body,
                    false,
                    priority);

            task.addTaskTag(tag);
            task.setDeadLine(validatedDeadline);

            taskList.add(task); // adiciona a task à lista

        }
    }

    @Override
    public void deleteTask(String taskName) {

        taskName = validate.requireNonEmpty(taskName, "DELETE TASK - NAME");

        Task taskToRemove = findTaskByName(taskName);
        if(taskToRemove == null){
            throw new IllegalArgumentException("[DELETE TASK - ERROR] Tarefa não encontrada.");
        } else {
            taskList.remove(taskToRemove);
        }
    }

    @Override
    public void addTagToTask(String taskName, String newTag){

        taskName = validate.requireNonEmpty(taskName, "TAG - NAME");
        newTag = validate.requireNonEmpty(newTag, "TAG - TAG");

        Task alteredTaskTag = findTaskByName(taskName);
        if(alteredTaskTag == null){
            throw new IllegalArgumentException("[TAG - ERROR] Tarefa não encontrada.");
        } else {
            taskList.remove(alteredTaskTag);
            alteredTaskTag.addTaskTag(newTag);
            taskList.add(alteredTaskTag);
        }
    }

    @Override
    public List<Task> getAllTasks(){
        return getTasksOrderedByPriority();
    }

    @Override
    public List<Task> getAllTasksByTag(String tag){
        return getTasksOrderedByTag(tag);
    }

    @Override
    public List<Task> getTasksFilteredByPriority(Priority priority){
        return filterByPriority(priority);
    }

    private List<Task> filterByPriority(Priority priority){
        return taskList.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    private List<Task> getTasksOrderedByTag(String tag){
        return taskList.stream()
                .filter(task -> task.getTag().equals(tag))
                .collect(Collectors.toList());
    }

    private Task findTaskByName(String name){
        return taskList.stream()
                .filter(task -> task.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private List<Task> getTasksOrderedByPriority(){
        List<Task> sortedList = new ArrayList<>(taskList);
        sortedList.sort(Comparator.comparingInt(t -> t.getPriority().getValue()));
        return sortedList;
    }
}

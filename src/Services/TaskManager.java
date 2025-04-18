package Services;

import Enums.TaskStatus;
import Interfaces.DataTimeInterface;
import Interfaces.LoggerInterface;
import Interfaces.ManagerInterface;

import Enums.Priority;
import Util.Validate.ValidateUtils;
import model.Task;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager implements ManagerInterface {

    private List<Task> taskList = new ArrayList<>();

    private final DataTimeInterface dataService;
    private final LoggerInterface logger;


    public TaskManager(DataTimeInterface dataService, LoggerInterface logger){
        this.dataService = dataService;
        this.logger = logger;
    }

    @Override
    public void createTask(String taskName, String body,
                           Priority priority, String tag,
                           int day, int month, int year, String type){  // criar task

        taskName = ValidateUtils.requireNonEmpty(taskName, "CREATE TASK - NAME");
        body = ValidateUtils.requireNonEmpty(body, "CREATE TASK - BODY");
        LocalDate validatedDeadline = dataService.createValidDeadLine(day, month, year);

        if(findTaskByName(taskName) != null){
            throw new IllegalArgumentException("[CREATE TASK - ERROR] Tarefa '" + taskName + "' já existe.");
        } else {
            Task task = new Task(taskName,
                    body,
                    priority);

            task.updateStatus(TaskStatus.IN_PROGRESS);
            task.addTaskTag(tag);
            task.setDeadLine(validatedDeadline);

            taskList.add(task); // adiciona a task à lista

            if(type.equals("CREATE")){
                logger.createdTaskLog(task);
            }
        }
    }

    @Override
    public void deleteTask(String taskName, String type) {

        taskName = ValidateUtils.requireNonEmpty(taskName, "DELETE TASK - NAME");

        Task taskToRemove = findTaskByName(taskName);
        if(taskToRemove == null){
            throw new IllegalArgumentException("[DELETE TASK - ERROR] Tarefa não encontrada.");
        } else {
            taskList.remove(taskToRemove);
            if(!type.equals("REGEN")) {
                logger.deletedTaskLog(taskToRemove);
            }
        }
    }

    @Override
    public void addTagToTask(String taskName, String newTag){

        taskName = ValidateUtils.requireNonEmpty(taskName, "TAG - NAME");
        newTag = ValidateUtils.requireNonEmpty(newTag, "TAG - TAG");

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

    // Métodos de filtro:

    @Override
    public List<Task> getAllTasksByTag(String tag){
        return getTasksOrderedByTag(tag);
    }

    @Override
    public List<Task> getTasksFilteredByPriority(Priority priority){
        return filterByPriority(priority);
    }

    @Override
    public List<Task> getTaskFilteredByIntervals(LocalDate start, LocalDate end){ return getTasksOrderedByDeadline(start, end); }

    @Override
    public List<Task> getTaskFilteredByStatus(String status){ return getTasksOrderedByStatus(status); }

    // Métodos auxiliares:

    @Override
    public Task findTaskByName(String name){
        return taskList.stream()
                .filter(task -> task.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void uploadTaskFromData(List<Task> uploadedTask){
        this.taskList = uploadedTask;
    }

    // Métodos privados:

    private List<Task> filterByPriority(Priority priority){
        return taskList.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    private List<Task> getTasksOrderedByStatus(String status){
        return taskList.stream()
                .filter(task -> task.getStatusDescription().equals(status))
                .collect(Collectors.toList());
    }

    private List<Task> getTasksOrderedByTag(String tag){
        return taskList.stream()
                .filter(task -> task.getTag().equals(tag))
                .collect(Collectors.toList());
    }

    private List<Task> getTasksOrderedByDeadline(LocalDate start, LocalDate end){
        return taskList.stream()
                .filter(task -> (!task.isBeforeDue(start) && !task.isAfterDue(end)))
                .collect(Collectors.toList());
    }

    private List<Task> getTasksOrderedByPriority(){
        List<Task> sortedList = new ArrayList<>(taskList);
        sortedList.sort(Comparator.comparingInt(t -> t.getPriority().getValue()));
        return sortedList;
    }
}

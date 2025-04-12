package Services;

import Interfaces.DataTime;
import Interfaces.Logger;
import Interfaces.Manager;
import model.Priority;
import model.Task;

import java.util.ArrayList;
import java.util.Comparator;
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
    public void createTask(String taskName, String body, Priority priority, String tag){  // criar task

        if(findTaskByName(taskName) != null){
            throw new IllegalArgumentException("Tarefa '" + taskName + "' já existe.");
        } else {
            String formatedData = dataService.format(dataService.getTimeNow()); // formata a data

            Task task = new Task(taskName,
                    body,
                    formatedData,
                    false,
                    priority);
            task.addTaskTag(tag);
            taskList.add(task); // adiciona a task à lista

        }
    }

    @Override
    public void deleteTask(String taskName) {
        Task taskFound = taskList.stream()
                .filter(task -> task.getName().equals(taskName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));
        taskList.remove(taskFound);

    }

    @Override
    public void addTagToTask(String task, String newTag){
        if(findTaskByName(task) == null){
            throw new IllegalArgumentException("Tarefa inexistente.");
        } else {
            Task alteredTaskTag = findTaskByName(task);
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

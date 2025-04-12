package App;

import Interfaces.*;
import Services.TaskManager;
import UI.TaskPrinter;
import Util.DataTimeService;
import Util.TaskLogger;
import model.Priority;

public class Main{

    public static void main(String[] args) {
        DataTime data = new DataTimeService();
        Logger logger = new TaskLogger();
        Manager taskManager = new TaskManager(data, logger);
        TaskPrinter printer = new TaskPrinter();

        taskManager.createTask("Testando", "Tem que testar", Priority.ALTO, "Trabalho");
        taskManager.createTask("Testando2", "Tem que testar1", Priority.ALTO, "Escola");
        taskManager.createTask("Testando3", "Tem que testar2", Priority.ALTO, "Trabalho");

        taskManager.deleteTask("Testando2");
        taskManager.createTask("Testando2", "Tem que testar1", Priority.BAIXO, "Escola");

        printer.printTasks(taskManager.getTasksFilteredByPriority(Priority.ALTO));
        taskManager.addTagToTask("Testando2", "Trabalho");
    }
}
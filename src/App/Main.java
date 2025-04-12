package App;

import Interfaces.*;

import Services.TaskManager;

import UI.TaskPrinter;

import Util.DataTimeService;
import Util.TaskLogger;
import Util.ValidadeUtils;

import model.Priority;

public class Main{

    public static void main(String[] args) {
        DataTime data = new DataTimeService();
        Logger logger = new TaskLogger();
        Validate validate = new ValidadeUtils();
        Manager taskManager = new TaskManager(data, logger, validate);
        TaskPrinter printer = new TaskPrinter();

        taskManager.createTask("Testando",
                "Tem que testar",
                Priority.ALTO,
                "Trabalho",
                12, 5, 2022);

        printer.printTasks(taskManager.getAllTasks());
    }
}
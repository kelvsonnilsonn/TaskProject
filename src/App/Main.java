package App;

import Interfaces.*;

import Services.TaskManager;

import UI.TaskPrinter;

import Util.*;

import model.Priority;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main{

    public static void main(String[] args) {

        DataTime data = new DataTimeService();
        Validate validate = new ValidadeUtils();

        Logger logger = createLogger(data);
        Manager taskManager = new TaskManager(data, logger, validate);

        try{
            TaskPrinter printer = new TaskPrinter();

            taskManager.createTask("Testando",
                    "Tem que testar",
                    Priority.ALTO,
                    "Trabalho",
                    12, 9, 2025);

            printer.printTasks(taskManager.getAllTasks());

            taskManager.completeTask("Testando");

        } finally {
            logger.close();
        }
    }

    private static Logger createLogger(DataTime timer){
        try{
            PrintWriter writer = new PrintWriter(
                    new FileWriter(FileLocations.TASK_LOG, true), true
            );
            return new TaskLogger(writer, timer);
        } catch(Exception e){
            System.err.println("ERRO ao criar o logger.");
            return new NullLogger();
        }
    }
}
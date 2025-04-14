package App;

import Interfaces.*;

import Services.TaskManager;

import UI.TaskPrinter;

import Util.*;

import Util.FileUtils.FileLocations;
import Util.FileUtils.FileUploader;

import Util.LogUtils.NullLogger;
import Util.LogUtils.TaskLogger;

import Enums.Priority;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main{

    public static void main(String[] args) {

        DataTime data = new DataTimeService();
        Validate validate = new ValidadeUtils();

        Logger logger = createLogger(data);
        Manager taskManager = new TaskManager(data, logger, validate);
        Uploader uploader = new FileUploader(taskManager);

        try{

            taskManager.uploadTaskFromData(uploader.taskUploaderFromText());
            TaskPrinter printer = new TaskPrinter();

            for(int i = 12; i<25; i++){
                String name = "Name" + i;
                taskManager.createTask(name,
                        "Tem que testar",
                        Priority.ALTO,
                        "Trabalho",
                        i, 9, 2025,
                        "CREATE");

            }

            printer.printTasks(taskManager.getTaskFilteredByIntervals(
                    data.createValidDeadLine(12, 9, 2025),
                    data.createValidDeadLine(16, 9, 2025))
            );

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
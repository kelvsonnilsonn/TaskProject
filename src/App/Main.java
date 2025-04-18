package App;

import Enums.Priority;
import Interfaces.*;

import Services.CompletedTaskManager;
import Services.TaskManager;

import UI.TaskPrinter;

import Util.Date.DataTimeService;
import Util.FileUtils.FileLocations;
import Util.FileUtils.FileUploader;

import Util.LogUtils.NullLogger;
import Util.LogUtils.TaskLogger;

import Util.ReminderService;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main{

    public static void main(String[] args) {

        DataTimeInterface data = new DataTimeService();
        LoggerInterface logger = createLogger(data);
        LoggerInterface completedLogger = createCompleteLogger(data);
        ManagerInterface taskManager = new TaskManager(data, logger);
        CompleteManagerInterface completer = new CompletedTaskManager(completedLogger, taskManager);
        UploaderInterface uploader = new FileUploader(taskManager);

        try{

            TaskPrinter printer = new TaskPrinter();
            ReminderInterface reminder = new ReminderService(printer);

            taskManager.uploadTaskFromData(uploader.taskUploaderFromText());
            System.out.println("Tarefas carregadas: " + taskManager.getAllTasks().size());

//            for(int i = 12; i<25; i++){
//                String name = "Name" + i;
//                taskManager.createTask(name, "Teste", Priority.ALTO, "Trabalho", i, 5, 2025, "CREATE");
//            }

            reminder.reminderTasks(taskManager.getAllTasks());

        } finally {
            logger.close();
        }
    }

    private static LoggerInterface createLogger(DataTimeInterface timer){
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

    private static LoggerInterface createCompleteLogger(DataTimeInterface timer){
        try{
            PrintWriter writer = new PrintWriter(
                    new FileWriter(FileLocations.COMPLETE_LOG, true), true
            );
            return new TaskLogger(writer, timer);
        } catch(Exception e){
            System.err.println("ERRO ao criar o logger.");
            return new NullLogger();
        }
    }
}
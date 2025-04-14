package Util.FileUtils;

import Interfaces.Manager;
import Interfaces.Uploader;
import Services.PriorityManager;
import model.Task;

import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Enums.Priority;

public class FileUploader implements Uploader {

    private Manager taskManager;

    public FileUploader(Manager taskManager){
        this.taskManager = taskManager;
    }

    @Override
    public List<Task> taskUploaderFromText(){
        Path path = Paths.get(FileLocations.LOG_UPLOADER);
        String[] data;

        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                data = line.trim().split("\\|");

                String action = data[1].trim();

                String name = data[2].split(" : ")[1].trim();
                String value = data[3].split(" : ")[1].trim();
                Priority priority = PriorityManager.getPriorityType(data[4].split(" : ")[1].trim());
                String tag = data[5].split(" : ")[1].trim();

                String[] dateParts = data[7].split(" : ")[1].trim().split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                if (action.equals("CREATED")) {
                    taskManager.createTask(name, value, priority, tag, day, month, year, "REGEN");
                } else if (action.equals("DELETED")) {
                    taskManager.deleteTask(name); // não tem como excluir algo que não foi criado antes.
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao receber logs da memória: " + e.getMessage());
            return new ArrayList<>();
        }

        return taskManager.getAllTasks();
    }
}

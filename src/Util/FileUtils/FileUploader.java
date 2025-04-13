package Util.FileUtils;

import Interfaces.Uploader;
import model.Task;

import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploader implements Uploader {
    @Override
    public List<Task> taskUploaderFromText(){
        List<Task> taskToUpload = new ArrayList<>();

        Path path = Paths.get(FileLocations.LOG_UPLOADER);

        try{
            List<String> lines = Files.readAllLines(path);

            // (...)

        } catch (Exception e){
            System.err.println("Erro ao receber logs da memória.");
            return new ArrayList<>();
        }

        return taskToUpload;
    }
}

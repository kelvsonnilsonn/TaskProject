package Interfaces;

import model.Task;

import java.util.List;

public interface UploaderInterface {
    List<Task> taskUploaderFromText();
    List<Task> taskUploaderFromDataBase();
    List<Task> taskUploaderFromJSON();
}

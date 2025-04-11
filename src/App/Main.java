package App;

import Interfaces.*;
import Services.TaskManager;
import Util.DataTimeService;
import Util.TaskLogger;

public class Main{

    public static void main(String[] args) {
        DataTime data = new DataTimeService();
        Logger logger = new TaskLogger();
        Manager taskManager = new TaskManager(data, logger);

        taskManager.createTask("Testando", "Tem que testar");
        taskManager.createTask("Testando2", "Tem que testar1");
        taskManager.createTask("Testando3", "Tem que testar2");

        taskManager.deleteTask("Testando2");
        taskManager.createTask("Testando2", "Tem que testar1");
        taskManager.createTask("Testando5", "Tem que testar1");
    }
}
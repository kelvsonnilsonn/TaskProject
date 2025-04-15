package Util;

import Interfaces.ManagerInterface;
import Services.CompletedTaskManager;

public class Metrics {
    private final CompletedTaskManager completer;
    private final ManagerInterface manager;

    public Metrics(CompletedTaskManager completer, ManagerInterface manager){
        this.completer = completer;
        this.manager = manager;
    }

    public double getRateCompletedTasks(){
        return (double) completer.getCompletedTasks().size() /(completer.getCompletedTasks().size() + manager.getAllTasks().size());
    }
}

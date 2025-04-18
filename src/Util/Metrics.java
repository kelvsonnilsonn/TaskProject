package Util;

import Interfaces.ManagerInterface;
import Interfaces.MetricsInterface;
import Services.CompletedTaskManager;

public class Metrics implements MetricsInterface {
    private final CompletedTaskManager completer;
    private final ManagerInterface manager;

    public Metrics(CompletedTaskManager completer, ManagerInterface manager){
        this.completer = completer;
        this.manager = manager;
    }

    @Override
    public double getRateCompletedTasks(){
        return (double) completer.getCompletedTasks().size() /(completer.getCompletedTasks().size() + manager.getAllTasks().size());
    }

    @Override
    public double getRateCompletedTasksInMonth(){
        return 0;
    }
}

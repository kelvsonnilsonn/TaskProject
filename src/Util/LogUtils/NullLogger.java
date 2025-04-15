package Util.LogUtils;

import Interfaces.LoggerInterface;
import model.Task;

public class NullLogger implements LoggerInterface {
    @Override
    public void createdTaskLog(Task task) {}

    @Override
    public void deletedTaskLog(Task task) {}

    @Override
    public void completedTaskLog(Task task) {}

    @Override
    public void close() {}
}

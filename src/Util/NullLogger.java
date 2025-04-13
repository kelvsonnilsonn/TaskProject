package Util;

import Interfaces.DataTime;
import Interfaces.Logger;
import model.Task;

public class NullLogger implements Logger {
    @Override
    public void createdTaskLog(Task task) {}

    @Override
    public void deletedTaskLog(Task task) {}

    @Override
    public void completedTaskLog(Task task) {}

    @Override
    public void close() {}
}

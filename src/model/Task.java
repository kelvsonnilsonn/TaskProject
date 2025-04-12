package model;

import java.util.Date;

public class Task {
    private final String taskName;
    private final String value;
    private final String data;
    private Priority priority;
    private boolean status;

    public Task(String name, String value, String date, boolean status, Priority priority){
        this.taskName = name;
        this.priority = priority;
        this.value = value;
        this.data = date;
        this.status = status;
    }

    public String getName() { return this.taskName; }
    public String getValue() { return this.value; }
    public String getDate() { return this.data; }

    public boolean getStatus() { return this.status; }

    public Priority getPriority() { return this.priority; }

    public void setStatus(boolean new_Status) { this.status = new_Status; }
    public void setPriority(Priority new_priority) { this.priority = new_priority; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Tarefa: ").append(getName()).append("\n");
        sb.append("Prioridade: ").append(getPriority()).append("\n");
        sb.append("Objetivo: ").append(getValue()).append("\n");
        sb.append("Data: ").append(getDate()).append("\n");
        sb.append("Status: ").append(getStatus() ? "Concluída\n" : "Pendente\n");
        // Melhor que "true/false"
        return sb.toString();
    }
}

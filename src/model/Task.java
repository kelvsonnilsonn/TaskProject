package model;

import java.util.Date;

public class Task {
    private final String taskName;
    private final String value;
    private final String data;
    private boolean status;

    public Task(String name, String value, String date, boolean status){
        this.taskName = name;
        this.value = value;
        this.data = date;
        this.status = status;
    }

    public String getName() { return this.taskName; }
    public String getValue() { return this.value; }
    public String getDate() { return this.data; }
    public boolean getStatus() { return this.status; }

    public void setStatus(boolean new_Status){ this.status = new_Status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarefa: ").append(getName()).append("\n");
        sb.append("Objetivo: ").append(getValue()).append("\n");
        sb.append("Data: ").append(getDate()).append("\n");
        sb.append("Status: ").append(getStatus() ? "Concluída" : "Pendente"); // Melhor que "true/false"
        return sb.toString();
    }
}

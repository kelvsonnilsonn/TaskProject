package model;

import java.util.Date;

public class Task {
    private String taskName;
    private String value;
    private Date data;
    private boolean status;

    public Task(String name, String value, Date date, boolean status){
        this.taskName = name;
        this.value = value;
        this.data = date;
        this.status = status;
    }

    public String getName() { return this.taskName; }
    public String getValue() { return this.value; }
    public Date getDate() { return this.data; }
    public boolean getStatus() { return this.status; }

    public void setStatus(boolean new_Status){ this.status = new_Status; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tarefa: ");
        sb.append(getName());
        sb.append("Objetivo: ");
        sb.append(getValue());
        sb.append("Data: ");
        sb.append(getDate());
        sb.append("Status: ");
        sb.append(getStatus());

        return sb.toString();

    }
}

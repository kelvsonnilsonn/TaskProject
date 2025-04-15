package model;

import Enums.Priority;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;


public class Task {
    private final String taskName;
    private final String value;
    private LocalDate deadline;
    private List<String> tag;
    private Priority priority;
    private String status;


    public Task(String name, String value, Priority priority){
        this.taskName = name;
        this.priority = priority;
        this.value = value;

        this.tag = new ArrayList<>();
    }

    public String getName() { return this.taskName; }
    public String getValue() { return this.value; }
    public List<String> getTag() { return this.tag; }
    public String getDeadlineFormatted() {
        return deadline.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public String getStatus() { return this.status; }

    public LocalDate getDeadline() { return this.deadline; }

    public boolean isOverDue() { return LocalDate.now().isAfter(deadline); } // checa se data atrasou!
    public boolean isAfterDue(LocalDate date) { return deadline.isAfter(date); }
    public boolean isBeforeDue(LocalDate date) { return deadline.isBefore(date); }

    public Priority getPriority() { return this.priority; }

    public void addTaskTag(String tagToAdd) { this.tag.add(tagToAdd); }
    public void setDeadLine(LocalDate deadline) { this.deadline = deadline; }
    public void setStatus(String new_Status) { this.status = new_Status; }
    public void setPriority(Priority new_priority) { this.priority = new_priority; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Tarefa: ").append(getName()).append("\n");
        sb.append("Prioridade: ").append(getPriority()).append("\n");
        sb.append("Objetivo: ").append(getValue()).append("\n");
        sb.append("Data: ").append(getDeadlineFormatted()).append("\n");
        sb.append("Status: ").append(getStatus()).append("\n");
        sb.append("Tag: ").append(getTag()).append("\n");
        // Melhor que "true/false"
        return sb.toString();
    }
}

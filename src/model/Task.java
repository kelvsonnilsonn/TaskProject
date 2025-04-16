package model;

import Enums.Priority;
import Enums.TaskStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {
    private final String taskName;
    private final String objective;
    private final List<String> tags;

    private LocalDate deadline;

    private Priority priority;
    private TaskStatus status;

    public Task(String name, String objective, Priority priority){
        this.taskName = Objects.requireNonNull(name);
        this.priority = Objects.requireNonNull(priority);
        this.objective = Objects.requireNonNull(objective);

        this.tags = new ArrayList<>();
        this.status = TaskStatus.CREATED;
    }

    // Getters String
    public String getName() { return this.taskName; }
    public String getObjective() { return this.objective; }
    public String getDeadlineFormatted() { return deadline.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); }
    public String getStatusDescription() { return status.getDescription(); }

    // Getters LocalDate
    public LocalDate getDeadline() { return this.deadline; }

    // Getters List
    public List<String> getTag() { return this.tags; }

    // Booleans
    public boolean isOverDue() { return LocalDate.now().isAfter(deadline); } // checa se data atrasou!
    public boolean isAfterDue(LocalDate date) { return deadline.isAfter(date); }
    public boolean isBeforeDue(LocalDate date) { return deadline.isBefore(date); }

    // Getters Priority
    public Priority getPriority() { return this.priority; }

    // Setters
    public void addTaskTag(String tagToAdd) { this.tags.add(tagToAdd); }
    public void setDeadLine(LocalDate deadline) { this.deadline = deadline; }
    public void setPriority(Priority priority) { this.priority = Objects.requireNonNull(priority); }
    public void updateStatus(TaskStatus newStatus) { this.status = newStatus; }
    public void addTag(String tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }
    public void removeTag(String tag) {
        tags.remove(tag);
    }

    @Override
    public String toString() {
        return String.format(
                "Tarefa: %s\nObjetivo: %s\nStatus: %s\nPrazo: %s\nPrioridade: %s\nTags: %s",
                taskName, objective, status.getDescription(),
                getDeadlineFormatted(), priority, String.join(", ", tags)
        );
    }
}

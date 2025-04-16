package Enums;

public enum TaskStatus {
    CREATED("Criada"),
    PENDING("Pendente"),
    IN_PROGRESS("Em progresso"),
    COMPLETED("Concluída"),
    CANCELED("Cancelada");

    private final String description;

    TaskStatus(String description){
        this.description = description;
    }

    public String getDescription(){ return this.description; }
}

package Enums;

public enum CompletionType {
    MANUAL("Conclusão manual"),
    AUTOMATED("Conclusão automática"),
    SCHEDULED("Conclusão programada");

    private final String description;

    CompletionType(String description){
        this.description = description;
    }

    public String getDescription(){ return this.description; }
}

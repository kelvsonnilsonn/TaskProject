package model;

public class PriorityManager {
    public static Priority getPriorityType(String type){
        Priority typeOfPriority = switch(type){
            case "ALTO" -> Priority.ALTO;
            case "MEDIO" -> Priority.MEDIO;
            case "BAIXO" -> Priority.BAIXO;
            default -> null;
        };

        return typeOfPriority;
    }
}

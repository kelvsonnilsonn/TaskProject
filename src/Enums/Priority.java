package Enums;

public enum Priority {
    BAIXO(10),
    MEDIO(5),
    ALTO(1);

    private final int value;

    Priority(int value){
        this.value = value;
    }

    public int getValue() { return this.value; }
}

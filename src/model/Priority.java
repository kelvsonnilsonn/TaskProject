package model;

public enum Priority {
    BAIXO(1),
    MEDIO(5),
    ALTO(10);

    private final int value;

    Priority(int value){
        this.value = value;
    }

    public int getValue() { return this.value; }
}

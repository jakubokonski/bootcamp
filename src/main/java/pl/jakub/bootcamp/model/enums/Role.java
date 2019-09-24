package pl.jakub.bootcamp.model.enums;

public enum Role {

    USER("Kursant"),
    COACH("Trener"),
    ADMIN("Admin");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }
}


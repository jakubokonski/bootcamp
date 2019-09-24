package pl.jakub.bootcamp.model.enums;

public enum CourseMode {

    DAY("Dzienny"),
    EVENING("Wieczorowy"),
    WEEKEND("Weekendowy"),
    ONLINE("Online");

    private final String displayName;

    CourseMode(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

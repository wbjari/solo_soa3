package domain;

import interfaces.ISprintState;

import java.time.LocalDateTime;

public class Sprint {

    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private ISprintState sprintState;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public boolean isUpdateable() {
        return sprintState.isUpdateable();
    }

    public void nextState() {
        this.sprintState = this.sprintState.nextState();
    }
}

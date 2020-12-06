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
        if(!isUpdateable()) {
            return;
        }

        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        if(!isUpdateable()) {
            return;
        }
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        if(!isUpdateable()) {
            return;
        }
        this.end = end;
    }

    public boolean isUpdateable() {
        return sprintState.isUpdateable();
    }

    public void nextState() {
        this.sprintState = this.sprintState.nextState();
    }
}

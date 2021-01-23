package domain;

import interfaces.ISprintState;

import java.time.LocalDateTime;

public class Sprint {

    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private ISprintState sprintState;

    public Sprint(ISprintState sprintState) {
        this.sprintState = sprintState;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if(!isUpdateable()) {
            return;
        } else {
            this.title = title;
        }
    }

    public LocalDateTime getStart() { return start; }
    public void setStart(LocalDateTime start) {
        if(!isUpdateable()) {
            return;
        } else {
            this.start = start;
        }
    }

    public LocalDateTime getEnd() { return end; }
    public void setEnd(LocalDateTime end) {
        if(!isUpdateable()) {
            return;
        } else {
            this.end = end;
        }
    }

    public void nextState() {
        this.sprintState = this.sprintState.nextState();
    }
    public ISprintState getState() {
        return this.sprintState;
    }
    public boolean isUpdateable() { return sprintState.isUpdateable(); }

}

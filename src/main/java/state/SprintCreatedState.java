package state;

import interfaces.ISprintState;

public class SprintCreatedState extends ISprintState {

    public ISprintState previousState() {
        return this;
    }
    public ISprintState nextState() {
        return new SprintExecutingState();
    }

    public boolean isUpdateable() {
        return true;
    }
}

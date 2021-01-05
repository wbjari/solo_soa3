package state;

import interfaces.ISprintState;

public class SprintFinishedState extends ISprintState {

    @Override
    public ISprintState previousState() {
        return this;
    }

    @Override
    public ISprintState nextState() {
        return this;
    }

    @Override
    public boolean isUpdateable() {
        return true;
    }
}

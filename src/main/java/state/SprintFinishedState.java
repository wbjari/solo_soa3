package state;

import interfaces.ISprintState;

public class SprintFinishedState implements ISprintState {

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

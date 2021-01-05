package state;

        import interfaces.ISprintState;

public class SprintExecutingState extends ISprintState {

    public ISprintState previousState() {
        return this;
    }

    public ISprintState nextState() {
        return new SprintFinishedState();
    }

    public boolean isUpdateable() {
        return false;
    }
}

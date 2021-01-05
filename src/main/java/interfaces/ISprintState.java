package interfaces;

public abstract class ISprintState {

    public abstract ISprintState previousState();
    public abstract ISprintState nextState();
    public abstract boolean isUpdateable();

}

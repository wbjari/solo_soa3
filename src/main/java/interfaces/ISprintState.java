package interfaces;

public interface ISprintState {

    ISprintState previousState();
    ISprintState nextState();
    boolean isUpdateable();

}

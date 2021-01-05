package state;

import domain.Item;
import interfaces.IState;

public class ScrumTodoState extends IState {
    @Override
    public IState nextState(Item item) {
        return new ScrumDoingState();
    }

    @Override
    public IState previousState() {
        return this;
    }
}

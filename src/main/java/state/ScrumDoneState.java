package state;

import domain.Item;
import interfaces.IState;

public class ScrumDoneState extends IState {
    @Override
    public IState nextState(Item item) {
        return this;
    }
    @Override
    public IState previousState() {
        return this;
    }
}

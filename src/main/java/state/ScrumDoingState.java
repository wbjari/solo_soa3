package state;

import domain.Item;
import interfaces.IState;

public class ScrumDoingState implements IState {

    @Override
    public IState nextState(Item item) {
        for(Item subItem : item.getSubItems()) {
            if(!(subItem.getState() instanceof ScrumDoneState)) {
                return this;
            }
        }

        return new ScrumDoneState();
    }

    @Override
    public IState previousState() {
        // SEND NOTIFICATION
        return new ScrumTodoState();
    }
}

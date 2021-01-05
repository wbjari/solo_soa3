package interfaces;

import domain.Item;

public abstract class IState {

    public abstract IState nextState(Item item);
    public abstract IState previousState();

}

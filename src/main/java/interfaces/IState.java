package interfaces;

import domain.Item;

public interface IState {

    IState nextState(Item item);
    IState previousState();

}

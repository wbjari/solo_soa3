package interfaces;

import event.ItemObserveEvent;

public interface IItemObservable {

    void registerObserver(IItemObserver observer);
    void removeObserver(IItemObserver observer);
    void notifyObservers(ItemObserveEvent itemObserveEvent);

}

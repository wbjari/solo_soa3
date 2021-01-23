import domain.Item;
import event.ItemObserveEvent;
import interfaces.IItemObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

class ItemObserverTest {

    private Item item;
    private ItemObserveEvent itemObserveEvent;


    @BeforeEach
    void beforeAllTests() {
        this.item = new Item();

        Item item2 = new Item();
        this.itemObserveEvent = new ItemObserveEvent(this.item, item2);
    }

    @Test
    @Order(1)
    void registerObserverTest() {
        IItemObserver observer = Mockito.mock(IItemObserver.class);

        this.item.notifyObservers(this.itemObserveEvent);

        Mockito.verify(observer, times(0)).update(this.itemObserveEvent);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        Mockito.verify(observer, times(1)).update(this.itemObserveEvent);
    }

    @Test
    @Order(2)
    void removeObserverTest() {
        IItemObserver observer = Mockito.mock(IItemObserver.class);

        this.item.notifyObservers(this.itemObserveEvent);

        Mockito.verify(observer, times(0)).update(this.itemObserveEvent);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        Mockito.verify(observer, times(1)).update(this.itemObserveEvent);

        this.item.notifyObservers(this.itemObserveEvent);

        Mockito.verify(observer, times(2)).update(this.itemObserveEvent);

        this.item.removeObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        Mockito.verify(observer, times(2)).update(this.itemObserveEvent);
    }

}

import domain.Item;
import domain.ScrumItemNotificationObserver;
import domain.User;
import event.ItemObserveEvent;
import interfaces.IItemObserver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.ScrumDoingState;
import state.ScrumDoneState;
import state.ScrumTodoState;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

class ScrumItemNotificationObserverTest {

    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    private Item item;
    private Item item2;
    private ItemObserveEvent itemObserveEvent;


    @BeforeEach
    void beforeAllTests() {
        this.item = new Item();
        this.item2 = new Item();
        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void afterAllTests() {
        System.setOut(systemOut);
    }


    @Test
    void scrumItemNotificationObserverTest() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("", getOutput());
    }

    @Test
    void ScrumItemNotificationObserverTestNotifyScrumMasterState() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        item.setState(new ScrumDoneState());
        item2.setState(new ScrumTodoState());

        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("Item changed from done back to to-do.", getOutput());
    }

    @Test
    void ScrumItemNotificationObserverTestNotifyScrumMasterUserChanged() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        User user1 = new User();
        User user2 = new User();

        item.setState(new ScrumDoingState());
        item.setUser(user1);

        item2.setState(new ScrumDoingState());
        item2.setUser(user2);

        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("Item is doing and user changed.", getOutput());
    }

    @Test
    void ScrumItemNotificationObserverTestUserChanged() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        User user1 = new User();
        User user2 = new User();

        item.setState(new ScrumTodoState());
        item.setUser(user1);

        item2.setState(new ScrumTodoState());
        item2.setUser(user2);

        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("", getOutput());
    }

    @Test
    void ScrumItemNotificationObserverTestStateChangeTodoDone() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        item.setState(new ScrumTodoState());

        item2.setState(new ScrumDoneState());

        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("", getOutput());
    }

    @Test
    void ScrumItemNotificationObserverTestStateChangeDoingTodo() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        item.setState(new ScrumDoingState());

        item2.setState(new ScrumTodoState());

        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("", getOutput());
    }

    @Test
    void ScrumItemNotificationObserverTestStateChangeDoingDoing() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        item.setState(new ScrumDoingState());

        item2.setState(new ScrumDoingState());

        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("", getOutput());
    }

    @Test
    void ScrumItemNotificationObserverTestStateChangeDoneDone() {
        IItemObserver observer = new ScrumItemNotificationObserver();

        item.setState(new ScrumDoneState());

        item2.setState(new ScrumDoneState());

        this.itemObserveEvent = new ItemObserveEvent(item, item2);

        this.item.registerObserver(observer);
        this.item.notifyObservers(this.itemObserveEvent);

        assertEquals("", getOutput());
    }

    private String getOutput() {
        return testOut.toString().replaceAll(System.getProperty("line.separator"), "");
    }

}

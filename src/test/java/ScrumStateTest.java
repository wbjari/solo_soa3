import domain.Item;
import interfaces.IState;
import org.junit.jupiter.api.*;
import state.ScrumDoingState;
import state.ScrumDoneState;
import state.ScrumTodoState;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScrumStateTest {

    private static IState state;
    private static Item item;

    @BeforeAll
    static void beforeAllTests() {
        state = new ScrumTodoState();
        item = new Item();
    }

    @Test
    @Order(1)
    // State = To-do.
    public void todoNextStateDoing() {
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoingState.class, state.getClass());
    }

    @Test
    @Order(2)
    // State = doing.
    public void doingNextStateDone() {
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    @Order(3)
    // State = Done. Done has no next, so stays in Done.
    public void doneNextState() {
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    @Order(4)
    // State = Done. Done can't go back to Doing, so stays in Done.
    public void donePreviousState() {
        state = state.previousState();

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    // State = To-do. To-do has no previous, so stays in To-do.
    public void todoPreviousState() {
        state = new ScrumTodoState();
        state = state.previousState();

        Assertions.assertEquals(ScrumTodoState.class, state.getClass());
    }

    @Test
    // State = Doing.
    public void doingPreviousStateTodo() {
        state = new ScrumDoingState();
        state = state.previousState();

        Assertions.assertEquals(ScrumTodoState.class, state.getClass());
    }

    @Test
    void doingNextStateDoneSubitemsDoing() {
        state = new ScrumDoingState();

        Item subItem = new Item();
        subItem.setState(new ScrumDoingState());

        Item subItem2 = new Item();
        subItem2.setState(new ScrumDoingState());

        Item item = new Item();
        item.addSubItem(subItem);
        item.addSubItem(subItem2);

        Assertions.assertEquals(ScrumDoingState.class, state.nextState(item).getClass());
    }

    @Test
    void doingNextStateDoneSubitemsDone() {
        state = new ScrumDoingState();

        Item subItem = new Item();
        subItem.setState(new ScrumDoneState());

        Item subItem2 = new Item();
        subItem2.setState(new ScrumDoneState());

        Item item = new Item();
        item.addSubItem(subItem);
        item.addSubItem(subItem2);

        Assertions.assertEquals(ScrumDoneState.class, state.nextState(item).getClass());
    }

}

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
    public void todoNextStateDoing() {     // State = To-do.
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoingState.class, state.getClass());
    }

    @Test
    @Order(2)
    public void doingNextStateDone() {    // State = doing.
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    @Order(3)
    public void doneNextState() {    // State = Done. Done has no next, so stays in Done.
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    @Order(4)
    public void donePreviousState() {    // State = Done. Done can't go back to Doing, so stays in Done.
        state = state.previousState();

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    public void todoPreviousState() {    // State = To-do. To-do has no previous, so stays in To-do.
        state = new ScrumTodoState();
        state = state.previousState();

        Assertions.assertEquals(ScrumTodoState.class, state.getClass());
    }

    @Test
    public void doingPreviousStateTodo() {    // State = Doing.
        state = new ScrumDoingState();
        state = state.previousState();

        Assertions.assertEquals(ScrumTodoState.class, state.getClass());
    }

    @Test
    void doingNextStateDoneSubitemsDoing() {    // State = Doing, subitems doing.
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
    void doingNextStateDoneSubitemsDone() {    // State = Doing, subitems Done.
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

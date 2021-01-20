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
    public void todoToDoingState() {
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoingState.class, state.getClass());
    }

    @Test
    @Order(2)
    public void doingToDoneState() {
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    @Order(3)
    public void doneNextStateNotChangingState() {
        state = state.nextState(item);

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    @Order(4)
    public void donePreviousStateNotChangingState() {
        state = state.previousState();

        Assertions.assertEquals(ScrumDoneState.class, state.getClass());
    }

    @Test
    @Order(5)
    public void todoPreviousStateNotChangingState() {
        state = new ScrumTodoState();
        state = state.previousState();

        Assertions.assertEquals(ScrumTodoState.class, state.getClass());
    }

    @Test
    @Order(6)
    public void doingPreviousStateToTodoState() {
        state = new ScrumDoingState();
        state = state.previousState();

        Assertions.assertEquals(ScrumTodoState.class, state.getClass());
    }

}

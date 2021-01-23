import domain.Sprint;
import interfaces.ISprintState;
import org.junit.jupiter.api.*;
import state.SprintCreatedState;
import state.SprintExecutingState;
import state.SprintFinishedState;

class SprintStateTest {

    private static Sprint sprint;
    private static ISprintState sprintState;

    @Test
    void createdNextStateExecuting() {    // State = Created.
        sprintState = new SprintCreatedState().nextState();;

        Assertions.assertEquals(SprintExecutingState.class, sprintState.getClass());
    }

    @Test
    void executingNextStateFinished() {    // State = Executing.
        sprintState = new SprintExecutingState().nextState();

        Assertions.assertEquals(SprintFinishedState.class, sprintState.getClass());
    }

    @Test
    void finishedNextState() {    // State = Finished. Finished has no next state, so stays in Finished.
        sprintState = new SprintFinishedState().nextState();

        Assertions.assertEquals(SprintFinishedState.class, sprintState.getClass());
    }

    @Test
    void finishedPreviousState() {    // State = Finished. Finished can't go back to executing, so it stays in Finished.
        sprintState = new SprintFinishedState().previousState();

        Assertions.assertEquals(SprintFinishedState.class, sprintState.getClass());
    }

    @Test
    void executingPreviousStateCreated() {    // State = Executing. Executing can't go back to created, so it stays in Executing.
        sprintState = new SprintExecutingState().previousState();

        Assertions.assertEquals(SprintExecutingState.class, sprintState.getClass());
    }

    @Test
    void createdPreviousState() {    // State = Created. Created has no previous, so it stays in Created.
        sprintState = new SprintCreatedState().previousState();

        Assertions.assertEquals(SprintCreatedState.class, sprintState.getClass());
    }

    @Test
    void setTitleSprintCreatedTest() {
        this.sprint = new Sprint(new SprintCreatedState());

        String expectedString = "Title: sprint created.";

        this.sprint.setTitle(expectedString);
        Assertions.assertEquals(expectedString, this.sprint.getTitle());
    }

    @Test
    void setTitleSprintCreatedPreviousStateTest() {
        ISprintState sprintState = new SprintCreatedState();
        Assertions.assertEquals(sprintState, sprintState.previousState());
    }

    @Test
    void setTitleSprintExecutingTest() {
        this.sprint = new Sprint(new SprintExecutingState());
        String expectedString = "Title: sprint in progress.";

        this.sprint.setTitle(expectedString);
        Assertions.assertNotEquals(expectedString, this.sprint.getTitle());
    }

    @Test
    void setTitleSprintFinishedTest() {
        this.sprint = new Sprint(new SprintCreatedState());

        String expectedString = "Title: sprint finished!";

        this.sprint.setTitle(expectedString);
        Assertions.assertEquals(expectedString, this.sprint.getTitle());
    }
}

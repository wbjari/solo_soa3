import domain.Sprint;
import interfaces.ISprintState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.SprintCreatedState;
import state.SprintExecutingState;
import state.SprintFinishedState;

class SprintStateTest {

    private Sprint sprint;

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

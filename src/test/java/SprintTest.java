import domain.Sprint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.SprintCreatedState;
import java.time.LocalDateTime;

class SprintTest {

    private Sprint sprint;

    @BeforeEach
    void beforeAllTests() {
        this.sprint = new Sprint(new SprintCreatedState());
    }

    @Test
    void setTitleTest() {
        String expectedString = "Sprint title";

        this.sprint.setTitle(expectedString);
        Assertions.assertEquals(expectedString, this.sprint.getTitle());
    }

    @Test
    void setStartTest() {
        LocalDateTime localDateTime = LocalDateTime.now();

        this.sprint.setStart(localDateTime);
        Assertions.assertEquals(localDateTime, this.sprint.getStart());
    }

    @Test
    void setEndTest() {
        LocalDateTime localDateTime = LocalDateTime.now();

        this.sprint.setEnd(localDateTime);
        Assertions.assertEquals(localDateTime, this.sprint.getEnd());
    }

    @Test
    void setStartNotUpdatableTest() {
        LocalDateTime localDateTime = this.sprint.getStart();

        this.sprint.nextState();
        this.sprint.setStart(LocalDateTime.now());
        Assertions.assertEquals(localDateTime, this.sprint.getStart());

    }

    @Test
    void setEndNotUpdateableTest() {
        LocalDateTime localDateTime = this.sprint.getEnd();

        this.sprint.nextState();
        this.sprint.setEnd(LocalDateTime.now());
        Assertions.assertEquals(localDateTime, this.sprint.getEnd());
    }
}
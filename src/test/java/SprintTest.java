import domain.Sprint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class SprintTest {

    private Sprint sprint;

    @BeforeEach
    public void beforeAllTests() {
        this.sprint = new Sprint();
    }

    @Test
    public void setTitleTest() {
        String expectedString = "Sprint 1";

        this.sprint.setTitle(expectedString);
        Assertions.assertEquals(expectedString, this.sprint.getTitle());
    }

    @Test
    public void setStartTest() {
        LocalDateTime localDateTime = LocalDateTime.now();

        this.sprint.setStart(localDateTime);
        Assertions.assertEquals(localDateTime, this.sprint.getStart());
    }

    @Test
    public void setEndTest() {
        LocalDateTime localDateTime = LocalDateTime.now();

        this.sprint.setEnd(localDateTime);
        Assertions.assertEquals(localDateTime, this.sprint.getEnd());
    }
}

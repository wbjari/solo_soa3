import domain.Message;
import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTest {

    private Message message;

    @BeforeEach
    public void beforeAllTests() {
        this.message = new Message();
    }

    @Test
    public void setTextTest() {
        String expectedString = "Lorem ipsum dolor sit amet..";

        this.message.setText(expectedString);
        Assertions.assertEquals(expectedString, this.message.getText());
    }

    @Test
    public void setUserTest() {
        User user = new User();

        this.message.setUser(user);
        Assertions.assertEquals(user, this.message.getUser());
    }

}

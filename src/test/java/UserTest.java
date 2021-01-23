import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    public void beforeAllTests() {
        this.user = new User();
    }

    @Test
    void setFirstNameTest() {
        String expectedString = "Pietje";

        this.user.setFirstName(expectedString);
        Assertions.assertEquals(expectedString, this.user.getFirstName());
    }

    @Test
    void setLastNameTest() {
        String expectedString = "van Dongen";

        this.user.setLastName(expectedString);
        Assertions.assertEquals(expectedString, this.user.getLastName());
    }

    @Test
    void setEmailTest() {
        String expectedString = "wbjari@gmail.com";

        this.user.setEmail(expectedString);
        Assertions.assertEquals(expectedString, this.user.getEmail());
    }

    @Test
    public void setNameTest() {
        String expectedString1 = "Jari";
        String expectedString2 = "Verhaard";

        this.user.setFirstName(expectedString1);
        this.user.setLastName(expectedString2);
        Assertions.assertEquals(expectedString1 + " " + expectedString2, this.user.getName());
    }

}

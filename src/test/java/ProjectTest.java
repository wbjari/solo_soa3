import adapter.SCMGitAdapter;
import domain.Item;
import domain.Project;
import domain.Thread;
import domain.User;
import factory.WorkboardScrumFactory;
import interfaces.ISCMAdapter;
import interfaces.IWorkboardFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectTest {

    private Project project;
    private IWorkboardFactory workboardFactory;
    private ISCMAdapter scmAdapter;

    @BeforeEach
    public void beforeAllTests() {
        this.workboardFactory = new WorkboardScrumFactory();
        this.scmAdapter = new SCMGitAdapter();
        this.project = new Project("My First Project", this.workboardFactory, scmAdapter);
    }

    @Test
    public void setNameTest() {
        String expectedString = "My first Editted Project";

        this.project.setName(expectedString);
        Assertions.assertEquals(expectedString, this.project.getName());
    }

    @Test
    public void addUserTest() {
        User user = new User();

        Assertions.assertEquals(0, this.project.getUsers().size());

        this.project.addUser(user);
        Assertions.assertEquals(1, this.project.getUsers().size());
    }

    @Test
    public void removeUserTest() {
        User user = new User();

        Assertions.assertEquals(0, this.project.getUsers().size());

        this.project.addUser(user);
        Assertions.assertEquals(1, this.project.getUsers().size());

        this.project.removeUser(user);
        Assertions.assertEquals(0, this.project.getUsers().size());
    }

    @Test
    public void addThreadTest() {
        Thread thread = new Thread();

        Assertions.assertEquals(0, this.project.getThreads().size());

        this.project.addThread(thread);
        Assertions.assertEquals(1, this.project.getThreads().size());
    }

    @Test
    public void removeThreadTest() {
        Thread thread = new Thread();

        Assertions.assertEquals(0, this.project.getThreads().size());

        this.project.addThread(thread);
        Assertions.assertEquals(1, this.project.getThreads().size());

        this.project.removeThread(thread);
        Assertions.assertEquals(0, this.project.getThreads().size());
    }

    @Test
    public void addItemTest() {
        Item item = new Item();

        Assertions.assertEquals(0, this.project.getItems().size());

        this.project.addItem(item);
        Assertions.assertEquals(1, this.project.getItems().size());
    }

    @Test
    public void removeItemTest() {
        Item item = new Item();

        Assertions.assertEquals(0, this.project.getItems().size());

        this.project.addItem(item);
        Assertions.assertEquals(1, this.project.getItems().size());

        this.project.removeItem(item);
        Assertions.assertEquals(0, this.project.getItems().size());
    }

    @Test
    public void getNewItemTest() {
        Item item = this.project.getNewItem();

        Assertions.assertEquals(item.getState().getClass(), this.workboardFactory.getItem().getState().getClass());
    }
}

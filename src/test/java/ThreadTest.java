import adapter.SCMGitAdapter;
import domain.Message;
import domain.Project;
import domain.Thread;
import factory.WorkboardScrumFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThreadTest {

    private Thread thread;

    @BeforeEach
    public void beforeAllTests() {
        this.thread = new Thread();
    }

    @Test
    public void constructorTest() {
        String expectedString = "First thread";
        Project expectedProject = new Project("My first project", new WorkboardScrumFactory(), new SCMGitAdapter());

        this.thread = new Thread(expectedString, expectedProject);

        Assertions.assertEquals(expectedString, this.thread.getName());
        Assertions.assertEquals(expectedProject, this.thread.getProject());
    }

    @Test
    public void setNameTest() {
        String expectedString = "Second thread";

        this.thread.setName(expectedString);
        Assertions.assertEquals(expectedString, this.thread.getName());
    }

    @Test
    public void setProjectTest() {
        Project project = new Project("My second project", new WorkboardScrumFactory(), new SCMGitAdapter());

        this.thread.setProject(project);
        Assertions.assertEquals(project, this.thread.getProject());
    }

    @Test
    public void addMessageTest() {
        Message message = new Message();
        message.setText("Lorem ipsum dolor ist amet..");

        Assertions.assertEquals(0, this.thread.getMessages().size());

        this.thread.addMessage(message);
        Assertions.assertEquals(1, this.thread.getMessages().size());
    }

    @Test
    public void removeMessageTest() {
        Message message = new Message();
        message.setText("Consectetur adipiscing elit..");

        Assertions.assertEquals(0, this.thread.getMessages().size());

        this.thread.addMessage(message);
        Assertions.assertEquals(1, this.thread.getMessages().size());

        this.thread.removeMessage(message);
        Assertions.assertEquals(0, this.thread.getMessages().size());
    }

}

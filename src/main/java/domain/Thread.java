package domain;

import java.util.ArrayList;
import java.util.List;

public class Thread {

    private String name;
    private Project project;
    private List<Message> messages;

    public Thread() {
        this.messages = new ArrayList<>();
    }

    public Thread(String name, Project project) {
        this.name = name;
        this.project = project;
        this.messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void removeMessage(Message message) {
        this.messages.remove(message);
    }
}

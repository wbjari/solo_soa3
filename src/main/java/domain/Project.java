package domain;

import interfaces.ISCMAdapter;
import interfaces.IWorkboardFactory;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private IWorkboardFactory workboardFactory;
    private String name;
    private List<User> users;
    private List<Thread> threads;
    private List<Item> items;
    private SCM scm;

    public Project(String name, IWorkboardFactory workboardFactory, ISCMAdapter iscmAdapter) {
        this.name = name;
        this.workboardFactory = workboardFactory;

        this.users = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.items = new ArrayList<>();

        this.scm = new SCM();
        this.scm.setScmAdapter(iscmAdapter);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return this.items;
    }
    public Item getNewItem() {
        return this.workboardFactory.getItem();
    }
    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public List<User> getUsers() {
        return this.users;
    }
    public void addUser(User user) {
        this.users.add(user);
    }
    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<Thread> getThreads() {
        return this.threads;
    }
    public void addThread(Thread thread) {
        this.threads.add(thread);
    }
    public void removeThread(Thread thread) {
        this.threads.remove(thread);
    }

    public ISCMAdapter getScmAdapter() {
        return scm.getScmAdapter();
    }
    public void setScmAdapter(ISCMAdapter scm) {
        this.scm.setScmAdapter(scm);
    }
}

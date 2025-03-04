package domain;

import event.ItemObserveEvent;
import interfaces.IItemObservable;
import interfaces.IItemObserver;
import interfaces.IState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item implements IItemObservable {

    private final List<IItemObserver> observerList;
    private final List<Item> subItems;
    private String title;
    private String description;
    private IState state;
    private Sprint sprint;
    private User user;

    public Item() {
        this.subItems = new ArrayList<>();
        this.observerList = new ArrayList<>();
    }

    public Item(Item item) {
        this.observerList = item.observerList;
        this.subItems = item.subItems;
        this.title = item.title;
        this.description = item.description;
        this.state = item.state;
        this.sprint = item.sprint;
        this.user = item.user;
    }

    public IState getState() {
        return state;
    }
    public void setState(IState state) {
        Item old = new Item(this);

        this.state = state;

        if(old.getState() != null && this.state != null && old.getState().getClass() != this.state.getClass()) {
            this.notifyObservers(new ItemObserveEvent(old, this));
        }
    }

    @Override
    public void registerObserver(IItemObserver observer) {
        this.observerList.add(observer);
    }
    @Override
    public void removeObserver(IItemObserver observer) {
        this.observerList.remove(observer);
    }
    @Override
    public void notifyObservers(ItemObserveEvent itemObserveEvent) {
        for(IItemObserver itemObserver: this.observerList) {
            itemObserver.update(itemObserveEvent);
        }
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        Item old = new Item(this);

        this.user = user;

        if(old.getUser() != null && this.user != null && !Objects.equals(old.getUser().getEmail(), this.user.getEmail())) {
            this.notifyObservers(new ItemObserveEvent(old, this));
        }
    }

    public Item[] getSubItems() {
        Item[] items = new Item[this.subItems.size()];
        items = this.subItems.toArray(items);
        return items;
    }
    public void addSubItem(Item subItem) {
        if(subItem == null || subItem.subItems.size() > 0){
            return;
        }

        this.subItems.add(subItem);
    }
    public void removeSubItem(Item subItem) {
        if(subItem != null && subItems.size() > 0){
            this.subItems.remove(subItem);
        }
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Sprint getSprint() {
        return sprint;
    }
    public void setSprint(Sprint sprint) {
        if(this.sprint != null && !this.sprint.isUpdateable()) {
            return;
        }
        this.sprint = sprint;
    }
}

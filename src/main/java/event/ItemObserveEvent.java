package event;

import domain.Item;

public class ItemObserveEvent {

    private Item oldValue;
    private Item newValue;

    public ItemObserveEvent(Item oldValue, Item newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Item getOldValue() {
        return oldValue;
    }
    public void setOldValue(Item oldValue) {
        this.oldValue = oldValue;
    }

    public Item getNewValue() {
        return newValue;
    }
    public void setNewValue(Item newValue) {
        this.newValue = newValue;
    }
}

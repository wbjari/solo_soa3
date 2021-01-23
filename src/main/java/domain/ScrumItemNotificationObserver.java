package domain;

import event.ItemObserveEvent;
import interfaces.IItemObserver;
import state.ScrumDoingState;
import state.ScrumDoneState;
import state.ScrumTodoState;

public class ScrumItemNotificationObserver implements IItemObserver {

    @Override
    public void update(ItemObserveEvent itemObserveEvent) {
        Item oldItem = itemObserveEvent.getOldValue();
        Item newItem = itemObserveEvent.getNewValue();

        // Item changes state from done to to-do
        if(oldItem.getState() instanceof ScrumDoneState && newItem.getState() instanceof ScrumTodoState) {
            System.out.println("Item changed from done back to to-do.");
        }

        // Item state is doing and user changes.
        if(oldItem.getState() instanceof ScrumDoingState && newItem.getState() instanceof ScrumDoingState && oldItem.getUser() != newItem.getUser()) {
            System.out.println("Item is doing and user changed.");
        }

    }
}

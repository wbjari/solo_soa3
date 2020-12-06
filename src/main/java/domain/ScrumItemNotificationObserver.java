package domain;

import event.ItemObserveEvent;
import interfaces.IItemObserver;
import state.ScrumDoingState;
import state.ScrumDoneState;
import state.ScrumTodoState;

import java.util.logging.Logger;

public class ScrumItemNotificationObserver implements IItemObserver {

    private final static Logger LOGGER = Logger.getLogger(ScrumItemNotificationObserver.class.getName());

    @Override
    public void update(ItemObserveEvent itemObserveEvent) {
        Item oldItem = itemObserveEvent.getOldValue();
        Item newItem = itemObserveEvent.getNewValue();

        // Item changes state from done to todo
        if(oldItem.getState() instanceof ScrumDoneState && newItem.getState() instanceof ScrumTodoState) {
            // TODO: Notify scrum master
            LOGGER.info("Notify scrum master: item state changed from done to todo");
        }

        // Item state is doing and user changes.
        if(oldItem.getState() instanceof ScrumDoingState && newItem.getState() instanceof ScrumDoingState) {
            if(oldItem.getUser() != newItem.getUser()) {
                // TODO: Notify scrum master
                LOGGER.info("Notify scrum master: item user changed");
            }
        }

    }
}

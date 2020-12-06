package factory;

import domain.Item;
import interfaces.IWorkboardFactory;

public class WorkboardKanbanFactory implements IWorkboardFactory {


    @Override
    public Item getItem() {
        Item item = new Item();
        // TODO: Implement Kanban Factory
        // item.setState();
        return item;
    }
}

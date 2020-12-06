package factory;

import domain.Item;
import interfaces.IWorkboardFactory;
import state.ScrumTodoState;

public class WorkboardScrumFactory implements IWorkboardFactory {
    @Override
    public Item getItem() {

        Item item = new Item();
        item.setState(new ScrumTodoState());
        return item;
    }
}

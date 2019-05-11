package Utilities.CyclicListIterator;

import java.util.List;

public class CyclicListIterator<T> {

    private final List<T> list;
    private int currentIndex = 0;

    public CyclicListIterator(List<T> list) {
        if(list.isEmpty())
            throw new ListNeedsToHaveAtLeastOneObject();

        this.list = list;
    }

    public T getCurrent() {
        return list.get(currentIndex);
    }

    public void next() {
        currentIndex = ++currentIndex % list.size();
    }
}

package Presentation.WelcomeViewPresenter;

import Presentation.WelcomeViewPresenter.Api.WelcomeViewDelegate;
import Utilities.Transaction.Transaction;

import java.util.LinkedList;
import java.util.List;

public class WelcomeViewPresenter implements WelcomeViewDelegate {

    private final WelcomeView view;
    private final List<Transaction> actions = new LinkedList<>();

    public WelcomeViewPresenter(WelcomeView view) {
        this.view = view;
    }

    public void addComingSoonAction(String name) {
        view.addComingSoonActionName(name);
    }

    public void addAction(Transaction action, String name) {
        view.addActionName(name);
        actions.add(action);
    }

    public void onActionClicked(int index) {
        throwIfIndexIsOutOfBounds(index);

        Transaction action = actions.get(index);
        action.execute();
    }

    private void throwIfIndexIsOutOfBounds(int index) {
        if(index < 0 || index >= actions.size())
            throw new ActionIndexNotAvailable();
    }

    public class ActionIndexNotAvailable extends RuntimeException {}

}

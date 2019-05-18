package Presentation.WelcomeViewPresenter;

public class WelcomeViewSpy implements WelcomeView {

    private String addedComingSoonActionName = "";
    private String addedActionName = "";

    public String getAddedComingSoonActionName() {
        return addedComingSoonActionName;
    }
    public void addComingSoonActionName(String name) {
        addedComingSoonActionName = name;
    }

    public String getAddedActionName() {
        return addedActionName;
    }
    public void addActionName(String name) {
        addedActionName = name;
    }

}

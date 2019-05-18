package FXView;

import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.List;

public class FXWelcomeView extends FXGameView {

    private static final Text welcome = new Text("Welcome to Board Games!");
    private static final Text question = new Text("Which game do You want to play?");
    private static final Font welcomeFont = new Font(14);

    private static final String comingSoonText = ComingSoonConstants.text;
    private static final Color comingSoonColor = ComingSoonConstants.color;
    private static final Font comingSoonFont = ComingSoonConstants.font;

    private final int width = 284;
    private final int height = 252;

    private int firstButtonIndex = 3;

    private final List<Button> buttons = new LinkedList<>();

    private final GridPane welcomePane = new GridPane();
    private final Text spacer = new Text();

    public FXWelcomeView() {
        init();
        initWelcome();
        initGrid();
        fillGrid();

        getChildren().add(welcomePane);
    }

    private void init() {
        setStyle("-fx-background-color: lightgray;");
    }

    private void initWelcome() {
        welcome.setFont(welcomeFont);
        question.setFont(welcomeFont);
    }

    private void initGrid() {
        welcomePane.setMaxSize(width, height);
        welcomePane.setMinSize(width, height);
        welcomePane.setPrefSize(width, height);
        welcomePane.setStyle("-fx-background-color: lightgray;");

        welcomePane.setHgap(10);
        welcomePane.setVgap(5);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        welcomePane.getColumnConstraints().addAll(col1, col2);
    }

    private void fillGrid() {
        welcomePane.add(welcome, 0, 0, 2, 1);
        welcomePane.add(question, 0, 1, 2, 1);
        welcomePane.add(spacer, 0, 2, 2, 1);
    }


    public void addGame(String gameName) {
        Button btn = makeButton(gameName);

        welcomePane.add(btn, 0, firstButtonIndex);
        buttons.add(btn);
        firstButtonIndex++;
    }

    public void addComingSoon(String gameName) {
        Button btn = makeButton(gameName);
        Text txt = makeComingSoonText();

        btn.setDisable(true);
        welcomePane.add(btn, 0, firstButtonIndex);
        welcomePane.add(txt, 1, firstButtonIndex);
        firstButtonIndex++;
    }


    private Button makeButton(String gameName) {
        Button btn = new Button(gameName);
        btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn.setMinSize(190, btn.getPrefHeight());
        return btn;
    }

    private Text makeComingSoonText() {
        Text txt = new Text(comingSoonText);
        txt.setFont(comingSoonFont);
        txt.setFill(comingSoonColor);
        return txt;
    }

}

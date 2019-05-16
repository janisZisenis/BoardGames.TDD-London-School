package BoardGames.View;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXPlayerConfigView extends Pane {

    private static final String human = "Human";
    private static final String humbleCPU = "CPU - Humble";
    private static final String invincibleCPU = "CPU - Invincible";
    private static final String aiCPU = "CPU - AI";


    private static final String comingSoon = ComingSoonConstants.text;
    private static final Color comingSoonColor = ComingSoonConstants.color;
    private static final Font comingSoonFont = ComingSoonConstants.font;
    private final Text comingSoonText = new Text(comingSoon);
    private final Color aiColor = Color.web("#848683");

    private final StackPane stack = new StackPane();
    private final GridPane grid = new GridPane();
    private final GridPane aiGrid = new GridPane();

    private final Text humanText = new Text(human);
    private final Text humbleText = new Text(humbleCPU);
    private final Text invincibleText = new Text(invincibleCPU);
    private final Text aiText = new Text(aiCPU);

    private final RadioButton humanRadio = new RadioButton();
    private final RadioButton humbleRadio = new RadioButton();
    private final RadioButton invincibleRadio = new RadioButton();
    private final RadioButton aiRadio = new RadioButton();

    private final int height = 110;
    private final int width = 170;

    public FXPlayerConfigView(String initialPlayerName) {
        init(initialPlayerName);
        fillGrid();

        stack.getChildren().add(grid);
        getChildren().add(stack);
    }

    private void fillGrid() {
        grid.add(humanRadio, 0, 0);
        grid.add(humbleRadio, 0, 1);
        grid.add(invincibleRadio, 0, 2);
        grid.add(aiRadio, 0, 3);

        grid.add(humanText, 1, 0);
        grid.add(humbleText, 1, 1);
        grid.add(invincibleText, 1, 2);

        aiGrid.setHgap(10);
        aiGrid.add(aiText, 0, 0);
        aiGrid.add(comingSoonText, 1, 0);
        grid.add(aiGrid, 1, 3);
    }

    private void init(String initialPlayerName) {
        setMaxSize(width, height);
        setMinSize(width, height);
        setPrefSize(width, height);

        grid.setHgap(5);
        grid.setVgap(10);

        aiRadio.setDisable(true);
        aiText.setFill(aiColor);
        comingSoonText.setFill(comingSoonColor);
        comingSoonText.setFont(comingSoonFont);
    }

}

package FXView.Configuration;

import FXView.ComingSoonConstants;
import Presentation.ChoosePlayerViewPresenter.Api.ChoosePlayerViewDelegate;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerView;
import Presentation.ChoosePlayerViewPresenter.PlayerType;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

import static Presentation.ChoosePlayerViewPresenter.PlayerType.*;

public class FXChoosePlayerView extends Pane implements ChoosePlayerView {

    private static final String human = "Human";
    private static final String humbleCPU = "CPU - HumbleCPU";
    private static final String invincibleCPU = "CPU - InvincibleCPU";
    private static final String aiCPU = "CPU - AI";

    private static final String comingSoon = ComingSoonConstants.text;
    private static final Color comingSoonColor = ComingSoonConstants.color;
    private static final Font comingSoonFont = ComingSoonConstants.font;
    private final Text comingSoonText = new Text(comingSoon);


    private final StackPane stack = new StackPane();
    private final GridPane grid = new GridPane();
    private final GridPane aiGrid = new GridPane();

    private final RadioButton humanRadio = new RadioButton(human);
    private final RadioButton humbleRadio = new RadioButton(humbleCPU);
    private final RadioButton invincibleRadio = new RadioButton(invincibleCPU);
    private final RadioButton aiRadio = new RadioButton(aiCPU);

    private final int height = 110;
    private final int width = 170;

    private HashMap<PlayerType, RadioButton> buttons = new HashMap<>();

    private ChoosePlayerViewDelegate delegate;

    public void setDelegate(ChoosePlayerViewDelegate delegate) {
        this.delegate = delegate;
    }

    public FXChoosePlayerView() {
        init();
        initButtonMap();
        fillGrid();

        stack.getChildren().add(grid);
        getChildren().add(stack);

        humanRadio.setOnAction(e -> onHumanClicked());
        humbleRadio.setOnAction(e -> onHumbleClicked());
        invincibleRadio.setOnAction(e -> onInvincibleClicked());
        aiRadio.setDisable(true);
    }

    private void init() {
        setMaxSize(width, height);
        setMinSize(width, height);
        setPrefSize(width, height);

        grid.setHgap(5);
        grid.setVgap(10);

        comingSoonText.setFill(comingSoonColor);
        comingSoonText.setFont(comingSoonFont);
    }

    private void initButtonMap() {
        buttons.put(Human, humanRadio);
        buttons.put(HumbleCPU, humbleRadio);
        buttons.put(InvincibleCPU, invincibleRadio);
    }

    private void fillGrid() {
        grid.add(humanRadio, 0, 0);
        grid.add(humbleRadio, 0, 1);
        grid.add(invincibleRadio, 0, 2);

        aiGrid.setHgap(10);
        aiGrid.add(aiRadio, 0, 0);
        aiGrid.add(comingSoonText, 1, 0);
        grid.add(aiGrid, 0, 3);
    }


    private void onHumanClicked() {
        if(delegate != null)
            delegate.onHumanClicked();
    }

    private void onHumbleClicked() {
        if(delegate != null)
            delegate.onHumbleCPUClicked();
    }

    private void onInvincibleClicked() {
        if(delegate != null)
            delegate.onInvincibleCPUClicked();
    }


    public void setSelectedPlayerType(PlayerType type) {
        deselectAllRadioButtons();
        buttons.get(type).setSelected(true);
    }

    private void deselectAllRadioButtons() {
        for (Map.Entry<PlayerType, RadioButton> me : buttons.entrySet()) {
            RadioButton b = me.getValue();
            b.setSelected(false);
        }
    }


}

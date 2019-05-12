package GuiGaming.Presentation.InputViewPresenter;

import GuiGaming.Presentation.InputViewPresenter.Api.InputViewDelegate;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class InputViewPresenter implements InputViewDelegate {

    private final InputProcessor processor;

    public InputViewPresenter(InputProcessor processor) {
        this.processor = processor;
    }


    public void onInputGenerated(int row, int col) {
        Input i = new Input(row, col);
        processor.process(i);
    }
}

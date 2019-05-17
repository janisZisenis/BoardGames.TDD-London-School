package FXView;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.control.Labeled;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class FXTextSizeTransition extends Transition {

    private Labeled label;
    private int start, end;

    public FXTextSizeTransition(Labeled label, int start, int end, int duration) {
        this.label = label;
        this.start = start;
        this.end = end - start;
        setCycleDuration(Duration.millis(duration));
        setInterpolator(Interpolator.LINEAR);
    }

    protected void interpolate(double frac) {
        int size = (int) (((end - start) * frac) + start);
        label.setFont(Font.font(size));
    }
}
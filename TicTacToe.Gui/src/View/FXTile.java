package View;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXTile extends StackPane {

    private Text text = new Text();

    public FXTile(int sideLength) {
        Rectangle border = new Rectangle(sideLength, sideLength);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        setAlignment(Pos.CENTER);
        getChildren().addAll(text, border);
    }

    public void setText(String s, Font f) {
        text.setText(s);
        text.setFont(f);
    }
}

package View;

import Lib.Games.MessagingGame.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXGame extends Application implements Game {

    private final FXShell shell;
    private final Game game;

    public FXGame(FXShell shell, Game game) {
        this.game = game;
        this.shell = shell;
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TicTacToe");
        Scene root = new Scene(shell);
        primaryStage.setScene(root);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void play() {
        launch();
        game.play();
    }
}

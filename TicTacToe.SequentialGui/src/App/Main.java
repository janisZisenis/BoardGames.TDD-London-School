package App;


import Lib.GameImp.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        TicTacToeFactory factory = new TicTacToeFactory();
        Game game = factory.makeGame();

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(factory.shell));
        primaryStage.setResizable(false);
        primaryStage.show();

        Thread t = new Thread() {
            public void run(){
                game.play();
            }
        };
        t.start();

    }
}

package App;

import App.notTested_Demo.TicTacToeMain;
import FXView.FXQuitTransaction.FXQuitTransaction;
import FXView.FXShell;
import FXView.FXWelcomeView;
import Presentation.LoadGameViewTransaction.LoadGameViewTransaction;
import Presentation.WelcomeViewPresenter.WelcomeViewPresenter;
import Utilities.Transaction.Transaction;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXShell shell = new FXShell();
        FXWelcomeView welcomeView = new FXWelcomeView();
        shell.load(welcomeView);

        Transaction cancelAction = new LoadGameViewTransaction(welcomeView, shell);

        WelcomeViewPresenter presenter = new WelcomeViewPresenter(welcomeView);
        welcomeView.setDelegate(presenter);

        presenter.addAction(new TicTacToeMain(shell, cancelAction), "TicTacToe");
        presenter.addComingSoonAction("Conway's Game of Life");
        presenter.addComingSoonAction("Four in a Row");
        presenter.addComingSoonAction("Draughts");
        presenter.addComingSoonAction("Chess");
        presenter.addAction(new FXQuitTransaction(), "Quit Board Games!");


        primaryStage.setTitle("Board Games");
        Scene scene = new Scene(shell);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }

}

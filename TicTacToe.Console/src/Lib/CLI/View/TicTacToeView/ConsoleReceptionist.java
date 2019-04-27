package Lib.CLI.View.TicTacToeView;

import Lib.Model.TicTacToe.Receptionist;

public class ConsoleReceptionist implements Receptionist {

    private final String salutation = "Welcome To TicTacToe";
    private final String leaveTaking = "Welcome To TicTacToe";

    public void salute() {
        System.out.println(salutation);
    }

    public void takeLeave() {
        System.out.println(leaveTaking);
    }
}

package Lib.CLI.View.TicTacToeView;

import Lib.Model.Game.Receptionist;

public class ConsoleReceptionist implements Receptionist {

    private final String salutation = "Welcome To Game";
    private final String leaveTaking = "Welcome To Game";

    public void salute() {
        System.out.println(salutation);
    }

    public void takeLeave() {
        System.out.println(leaveTaking);
    }
}

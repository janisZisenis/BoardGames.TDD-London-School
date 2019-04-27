package Lib.CLI.View.TicTacToeView;

import Lib.Model.TicTacToe.Receptionist;

public class ConsoleReceptionist implements Receptionist {

    public void salute() {
        System.out.println("Welcome To TicTacToe");
    }

    public void takeLeave() {
        System.out.println("Thank you for playing TicTacToe! Good Bye");
    }
}

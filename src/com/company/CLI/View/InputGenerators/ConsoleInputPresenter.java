package com.company.CLI.View.InputGenerators;

import com.company.Data.Input.Input;
import com.company.Model.InputGenerators.PresentingInputGenerator.InputPresenter;

public class ConsoleInputPresenter implements InputPresenter {

    public void show(Input input) {
        System.out.println("The inserted input is: Input[" + input.getRow() + "," + input.getColumn() + "]");
    }

}

package Lib.Model.InputGenerators.AlertingInputGenerator;

import Lib.Data.Input.Input;

import java.util.Arrays;

public class InputRefereeStub implements InputReferee {

    private Input[] valids = {};

    public void setValidInputs(Input[] generated) {
        this.valids = generated;
    }

    public boolean isValid(Input input) {
        return Arrays.asList(valids).contains(input);
    }

    public void alertIsInvalid(Input input) {}
}

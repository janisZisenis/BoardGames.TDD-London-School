//package com.company.OnBoardInputGenerator;
//
//import com.company.UserInput;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class OnBoardInputGeneratingAlertOrderTest implements InputGenerator, IsOnBoardValidator, IsNotOnBoardAlerter{
//
//    private OnBoardInputGenerator sut;
//    private String logString = "";
//
//    private InputGeneratorStub inputGenerator = new InputGeneratorStub();
//    private IsOnBoardValidatorStub validator = new IsOnBoardValidatorStub();
//
//    @Test
//    void IfFirstUserInputIsNotOnField_ShouldFirstAlertBeforeGeneratingANewUserInput() {
//        makeFirstInputIsNotOnField();
//        sut = new OnBoardInputGenerator(this, this);
//
//        sut.generateInput();
//
//        String actual = logString;
//        String expected = "generate_validate_alert_generate_validate_";
//        assertEquals(expected, actual);
//    }
//
//    private void makeFirstInputIsNotOnField() {
//        validator.setTimesUserInputIsNotOnBoard(1);
//
//        UserInput[] inputs = new UserInput[]{ new UserInput(0, 1),
//                new UserInput(1, 2 ) };
//        inputGenerator.setUserInputs(inputs);
//    }
//
//    public UserInput generateInput() {
//        logString += "generate_";
//        return inputGenerator.generateInput();
//    }
//
//    public void alert() {
//        logString += "alert_";
//    }
//
//    public boolean isOnBoard(UserInput input) {
//        logString += "validate_";
//        return validator.isOnBoard(input);
//    }
//}

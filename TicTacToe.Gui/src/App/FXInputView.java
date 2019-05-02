package App;

import Lib.Data.Input.Input;
import Lib.Players.InputGenerator;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;


public class FXInputView extends Pane implements InputGenerator {

    private final String rowTitle = "Row:";
    private final String colTitle = "Column:";
    private final String submitTitle = "Submit";
    private final GridPane grid = new GridPane();
    private final Label rowLabel = new Label(rowTitle);
    private final Label colLabel = new Label(colTitle);
    private final TextField rowField = new TextField();
    private final TextField colField = new TextField();
    private final Button submit = new Button(submitTitle);

    private boolean submitted = false;

    public FXInputView(int width) {
        setPrefHeight(width);

        initRowField();
        initColumnField();
        initSubmitButton();
        initalizeGrid();

        getChildren().addAll(grid);
    }

    private void initSubmitButton() {
        submit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        submit.setDisable(true);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                submitted = true;
            }
        });
    }

    private void initColumnField() {
        colField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changedColumn(observable, oldValue, newValue);
            }
        });
    }

    private void initRowField() {
        rowField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changedRow(observable, oldValue, newValue);
            }
        });
    }

    private void initalizeGrid() {
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        GridPane.setConstraints(rowLabel, 0, 0);
        GridPane.setConstraints(colLabel, 0, 1);
        GridPane.setConstraints(rowField, 1, 0);
        GridPane.setConstraints(colField, 1, 1);
        GridPane.setConstraints(submit, 0, 2, 2, 1);

        grid.getChildren().addAll(rowLabel, colLabel, rowField, colField, submit);

        ColumnConstraints col1 = new ColumnConstraints(55);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);

        grid.getColumnConstraints().addAll(col1, col2);
    }


    public Input generate() {
        enableTextFields();
        Input input = waitForInput();
        resetControlStates();
        return input;
    }

    private void enableTextFields() {
        Platform.runLater(() -> {
            colField.setDisable(false);
            rowField.setDisable(false);
        });
    }

    private Input waitForInput() {
        while(!submitted) {
            sleep(1);
        }
        return makeInput();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Input makeInput() {
        return new Input(Integer.valueOf(rowField.getText()), Integer.valueOf(colField.getText()));
    }

    private void resetControlStates() {
        Platform.runLater(() -> {
            submitted = false;
            colField.setDisable(true);
            rowField.setDisable(true);
            submit.setDisable(true);
            colField.setText("");
            rowField.setText("");
        });
    }



    public void changedRow(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        Platform.runLater(() -> {
            updatedFrom(rowField, oldValue, newValue);
        });
    }

    public void changedColumn(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        Platform.runLater(()-> {
            updatedFrom(colField, oldValue, newValue);
        });
    }


    private void updatedFrom(TextField field, String oldValue, String newValue) {
        updateTextField(field, oldValue, newValue);
        updateSubmitState();
    }

    private void updateTextField(TextField field, String oldValue, String newValue) {
        if(isNotANumber(newValue)) {
            field.setText(oldValue);
        }
    }

    private boolean isNotANumber(String value) {
        return !value.isEmpty() && !value.matches("^[0-9]+?");
    }

    private void updateSubmitState() {
        boolean enabled = !rowField.getText().isEmpty() && !colField.getText().isEmpty();
        submit.setDisable(!enabled);
    }

}

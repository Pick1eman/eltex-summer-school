package ru.eltex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button button;
    @FXML
    public void click(ActionEvent actionEvent){
        this.button.setText("OK");
    }
}

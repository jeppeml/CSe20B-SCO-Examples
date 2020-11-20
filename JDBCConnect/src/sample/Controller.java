package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.be.Person;
import sample.dal.PersonDAO;

import java.util.List;

public class Controller {
    @FXML private ListView<Person> lstPersons;
    @FXML private TextField txtId;
    private PersonDAO personDAO  = new PersonDAO();

    public void clickLoad(ActionEvent actionEvent) {
        List<Person> persons = personDAO.getAll();
        lstPersons.getItems().clear();
        lstPersons.getItems().addAll(persons);
    }

    public void clickDestroy(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtId.getText());
        personDAO.delete(id);
    }
}

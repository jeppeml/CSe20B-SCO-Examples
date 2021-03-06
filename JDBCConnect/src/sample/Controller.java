package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.be.Person;
import sample.dal.PersonDAO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextField txtName;
    @FXML private TextField txtYear;
    @FXML private ListView<Person> lstPersons;
    @FXML private TextField txtId;

    private PersonDAO personDAO  = new PersonDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // txtId
       // lstPersons.getSelectionModel().getSelectedItem()
       // Event way of doing it

        lstPersons.getSelectionModel().selectedItemProperty().addListener(
               (obs, oldVal, newVal) -> {
                   if(newVal!=null){
                    txtId.setText(newVal.getId()+"");
                    txtName.setText(newVal.getName());
                    txtYear.setText(newVal.getBirthyear()+"");
                   }
               });

       // Property binding way of doing it

        //txtId.textProperty().bind(lstPersons.getSelectionModel().selectedItemProperty()..idProperty().asString());

    }

    public void clickLoad(ActionEvent actionEvent) {
        List<Person> persons = personDAO.getAll();

        lstPersons.getItems().clear();
        lstPersons.getItems().addAll(persons);
    }

    public void clickDestroy(ActionEvent actionEvent) {
        //int id = Integer.parseInt(txtId.getText());
        Person selectedPerson = lstPersons.getSelectionModel().getSelectedItem();
        personDAO.delete(selectedPerson.getId());
        lstPersons.getItems().remove(selectedPerson);
    }


    public void clickUpdate(ActionEvent actionEvent) {
        Person selectedPerson = lstPersons.getSelectionModel().getSelectedItem();
        selectedPerson.setBirthyear(Integer.parseInt(txtYear.getText()));
        selectedPerson.setName(txtName.getText());
        personDAO.update(selectedPerson);
    }
}

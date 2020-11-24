package sample.be;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty birthyear = new SimpleIntegerProperty();

    public Person(int id, String name) {
        this.id.set(id);
        this.name.set(name);
    }

    public Person(int id, String name, int birthyear) {
        this.id.set(id);
        this.name.set(name);
        this.birthyear.set(birthyear);
    }

    public SimpleIntegerProperty idProperty(){
        return idProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public SimpleStringProperty nameProperty(){
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleIntegerProperty birthyearProperty(){
        return birthyear;
    }

    public int getBirthyear() {
        return birthyear.get();
    }

    public void setBirthyear(int birthyear) {
        this.birthyear.set(birthyear);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthyear=" + birthyear +
                '}';
    }

    public String toSQLString{
        String sqlString="insert into Movies (id, title, year) values (1, 'Chan', 1998)\n";

        return sqlString;
    }
}

package sample;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    public ListView<String> lstPersons;

    public void clickLoad(ActionEvent actionEvent) {
        System.out.println("Rhello!");
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setUser("CSe20B_40");
        dataSource.setPassword("CSe20B_40");
        dataSource.setDatabaseName("Test2");

        try (Connection con = dataSource.getConnection();){
            String sql = "SELECT * FROM Persons ORDER BY name";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Integer birthyear = rs.getInt("birthyear");
                lstPersons.getItems().add(id+", " + name + ", " + birthyear);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

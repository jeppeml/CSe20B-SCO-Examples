package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private SQLServerDataSource dataSource;

    public PersonDAO() {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setUser("CSe20B_40");
        dataSource.setPassword("CSe20B_40");
        dataSource.setDatabaseName("Test2");

    }

    public List<Person> getAll(){
        List<Person> persons = new ArrayList<>();
        try (Connection con = dataSource.getConnection();){
            String sql = "SELECT * FROM Persons ORDER BY name";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Integer birthyear = rs.getInt("birthyear");
                Person p = new Person(id, name, birthyear);
                persons.add(p);
            }
            return persons;
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public void delete(int id) {
        try(Connection con = dataSource.getConnection()){
            String sql = "DELETE FROM Persons WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Statement stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Person person) {
        try(Connection con = dataSource.getConnection()){
            String sql = "UPDATE Persons SET name=?, birthyear=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getBirthyear());
            pstmt.setInt(3, person.getId());
            pstmt.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

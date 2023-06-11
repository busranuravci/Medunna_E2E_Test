package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

public class DatabaseTestStepDef {

    Connection connection;
    Statement statement;

    @Given("connect to database")
    public void connectToDatabase() throws SQLException {

       connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");
       statement = connection.createStatement();

    }


    @Then("read room and validate")
    public void readRoomAndValidate() throws SQLException {

       ResultSet resultSet = statement.executeQuery("SELECT * FROM room");
       resultSet.next();
       resultSet.next();
       resultSet.next();

        System.out.println(resultSet.getString("description"));
    }

}

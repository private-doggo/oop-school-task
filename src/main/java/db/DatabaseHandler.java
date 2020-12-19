package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler extends Config {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        /*Statement st = dbConnection.createStatement();

        String table = "CREATE TABLE `lab3`.`movies` (\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `description` VARCHAR(45) NOT NULL,\n" +
                "  `price` INT NOT NULL);";

        st.executeUpdate(table);*/

        return dbConnection;
    }
}

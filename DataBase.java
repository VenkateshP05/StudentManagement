import java.sql.Connection;
import java.sql.DriverManager;

/*
* Java DataBase Connectivity
* 1. import package -> java.sql
* 2. Load and register the driver -> com.mysql.jdbc.Driver
* 3. establish connection -> Connection interface and DriverManager class
* 4. Statement
* 5.execution
* */
public class DataBase {

    public Connection connection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/studentManagement";
        String userName = "root";
        String pass = "Root@1qaz";

        //Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, pass);
        return con;
    }

}

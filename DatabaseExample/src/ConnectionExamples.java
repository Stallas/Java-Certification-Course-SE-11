import java.sql.Connection;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionExamples {
    // A MySql database named testone, needs to exist.
    static String mySqlConnectionString = "jdbc:mysql://localhost:3306/testone";

    // derby database will get created in current working directory
    static String derbyFileConnectionString = "jdbc:derby:db/derby/DatabaseDemo;create=true";

    // in memory derby database
    static String derbyMemoryConnectionString = "jdbc:derby:memory/derby/DatabaseDemo;create=true";

    // SQLite connection, DatabaseDemo.db will get created
    static String sqliteConnectionString = "jdbc:sqlite:db\\sqlite\\DatabaseDemo.db";

    public static void main(String[] args) {

    }

    // Test multiple types of connections
    public static Connection getConnection(String connectionString) throws SQLException {

        Connection c;

        /*
        Prior to JDBC 4.0 (Java 6), code required to for classloader to load driver class,
        using class.forName. Code does nothing here, but exam may test you on it, note, exceptions
        may occur if no derby.
         */

        try {
            Class.forName("org.apache.derby.iapi.jdbc.InternalDriver");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(connectionString.equals("mysql") > -1){

            /*
            Adding additional properties - you would not really put database username/password
            in code.
             */
            String username = "newuser";
            String password = "new_user_2020"; 
        }
    }
}

package cursos.dio;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public static java.sql.Connection connect() throws SQLException {
        String user = "root";
        String password = "password";
        String urlConnection = "jdbc:mysql://localhost/adriano_cursos";
        java.sql.Connection conn = null;

        try {
            conn = DriverManager.getConnection(urlConnection, user, password);
            System.out.println("Connection Successfully!");
        } catch (SQLException e) {
            System.out.println("Connection Failed!!!");
        }

        return conn;
    }
}

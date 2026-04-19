import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() throws Exception {

        String url = "jdbc:mysql://localhost:3306/security_maps";
        String user = "root";
        String password = "Vinicius2006@@";

        return DriverManager.getConnection(url, user, password);
    }
}

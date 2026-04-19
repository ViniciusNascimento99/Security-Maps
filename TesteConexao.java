import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/security_maps",
                "root",
                "Vinicius2006@@"
            );

            System.out.println("Conectado com sucesso!");
            conn.close();

        } catch (Exception e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }
    }
}
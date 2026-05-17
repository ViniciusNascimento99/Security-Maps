import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ocorrencia2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("-----> Cadastro de Ocorrência <-----");

        // Dados da ocorrência
        System.out.print("Digite a descrição: ");
        String descricao = entrada.nextLine();

        System.out.print("Digite a localização: ");
        String localizacao = entrada.nextLine();

        System.out.print("Digite a data da ocorrência (AAAA-MM-DD): ");
        String data_ocorrencia = entrada.nextLine();

        System.out.print("Digite o nível de risco: ");
        String nivel_risco = entrada.nextLine();

        System.out.print("Digite o ID do usuário: ");
        int id_usuario = entrada.nextInt();

        // Banco de Dados
        try {

            Connection conn = Conexao2.conectar();

            String sql = "INSERT INTO ocorrencia (descricao, localizacao, data_ocorrencia, nivel_risco, id_usuario) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, descricao);
            stmt.setString(2, localizacao);
            stmt.setString(3, data_ocorrencia);
            stmt.setString(4, nivel_risco);
            stmt.setInt(5, id_usuario);

            stmt.executeUpdate();

            System.out.println("Ocorrência cadastrada com sucesso!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

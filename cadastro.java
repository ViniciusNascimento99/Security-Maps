import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class cadastro {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("---------- > Security Maps < ----------");
        System.out.println("----- Faça seu cadastro -----");

        // Cadastro
        System.out.print("Crie seu usuário: ");
        String usuarioCorreto = entrada.nextLine();

        System.out.print("Crie sua senha: ");
        String senhaCorreta = entrada.nextLine();

        // Banco de dados
        try {
            Connection conn = Conexao.conectar();

            String sql = "INSERT INTO usuario (nome, senha) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuarioCorreto);
            stmt.setString(2, senhaCorreta);
            stmt.executeUpdate();

            System.out.println("Salvo no banco!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nCadastro realizado com sucesso!");
        System.out.println("\n----- Faça seu login -----");

        // Login com 3 tentativas
        int tentativa = 0;

        while (tentativa < 3) {

            System.out.print("Usuário: ");
            String usuario = entrada.nextLine();

            System.out.print("Senha: ");
            String senha = entrada.nextLine();

            if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
                System.out.println("\nLogin realizado com sucesso!");
                System.out.println("Bem-vindo ao Security Maps!");
                break;
            } else {
                tentativa++;
                System.out.println("Dados incorretos.");

                if (tentativa < 3) {
                    System.out.println("Tente novamente.\n");
                } else {
                    System.out.println("\nAcesso bloqueado.");
                }
            }
        }

        entrada.close();
    }
}
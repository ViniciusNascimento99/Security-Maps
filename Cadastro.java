import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Cadastro {
    public static void main(String[] args) {
        
        // Nome do Scanner 
        Scanner entrada = new Scanner(System.in);

        // Apresentação 
        System.out.println("--------> Security Maps <--------");
        System.out.println("     -----> Cadastro <-----");

        // Dados dos Usuário
        System.out.print("Digte seu nome: ");
        String nome = entrada.nextLine();
        System.out.print("Digite sua data de nascimento (AAAA-MM-DD): ");
        String data_nascimento = entrada.nextLine();
        System.out.print("Digite seu CPF (somente núemros): ");
        String cpf = entrada.nextLine();
        System.out.print("Digite seu número: ");
        String telefone = entrada.nextLine();
        System.out.print("Crie sua senha: ");
        String senha = entrada.nextLine();

        // Validação de Dados 
        while (cpf.length() != 11 || !cpf.matches("\\d+")) {
            System.out.print("CPF inválido! Digite novamente: ");
            cpf = entrada.nextLine();
        }
        
        while (telefone.length() < 11 || !telefone.matches("\\d+")) {
            System.out.print("Número inválido! Digite novamente: ");
            telefone = entrada.nextLine();
        }

        while (senha.length() < 6) {
            System.out.print("Senha fraca! Digite novamente: ");
            senha = entrada.nextLine();
        }

        // Validação Concluída
        System.out.println("Cadastro Feito");
        System.out.print("Olá, "+ nome + ". Seja Bem vindo ao Security Maps");

        // Bando de Dados 
        try {
            Connection conn = Conexao.conectar();

            String sql = "INSERT INTO usuario (nome, data_nascimento, cpf, telefone, senha) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, data_nascimento);
            stmt.setString(3, cpf);
            stmt.setString(4, telefone);
            stmt.setString(5, senha);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
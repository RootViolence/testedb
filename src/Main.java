import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                try (Connection conn = db.conectar()) {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM pessoas WHERE ID = 4");
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome"));
                    }

                } catch (SQLException e) {
                    System.out.println("Erro de conexão: " + e.getMessage());
                    e.printStackTrace();
                }
        String sqlInsercao = "INSERT INTO pessoas (nome) VALUES (?)";
        System.out.println("Qual é o seu nome: ");
        String nomeUsuario = sc.nextLine();

        try (Connection conn = db.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsercao)) {

            pstmt.setString(1, nomeUsuario);
            int linhasAfetadas = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
        }



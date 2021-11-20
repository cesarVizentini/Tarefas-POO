package ex21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteConexao {
    private static final String DBURL = "jdbc:mariadb://localhost:3308/poo";
    private static final String DBUSER = "root";
    private static final String DBPASS= "";

    public static void main(String[] args) throws Exception {
        System.out.println("Teste de conexão em DB");
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Classe de conexao carregada");
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        System.out.println("Conectado no banco de dados");

//        String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento) " +
//                "VALUES (2, 'Caramelo', 'ViraLata', 10.76, '2017-11-09')";
//
//        PreparedStatement stmt = con.prepareStatement(sql);
//        stmt.executeUpdate();

        String sql = "SELECT * FROM pet";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("nome"));
            System.out.println(rs.getString("raca"));
            System.out.println(rs.getDouble("peso"));
            System.out.println(rs.getDate("nascimento"));
            System.out.println("--------------------------------------");
        }

        con.close();
    }
}

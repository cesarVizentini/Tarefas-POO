package ex22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO{

    private static final String DBURL = "jdbc:mariadb://localhost:3308/poo?allowMultiQueries=true";
    private static final String DBUSER = "root";
    private static final String DBPASS = "258460";

    public CursoDAOImpl() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adicionar(Curso curso) {
        try {
            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

            String sql = "INSERT INTO curso (id, nome, descricao, ativo, inicio, termino)  " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, curso.getId());
            stmt.setString(2, curso.getNome());
            stmt.setString(3, curso.getDescricao());
            stmt.setBoolean(4, curso.isAtivo());
            stmt.setDate(5, java.sql.Date.valueOf(curso.getInicio()));
            stmt.setDate(6, java.sql.Date.valueOf(curso.getTermino()));
            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Curso> pesquisarPorNome(String nome) {
        List<Curso> encontrados = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

            String sql = "SELECT * FROM curso WHERE nome like '%" + nome + "%'";
            System.out.println(sql);

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                Curso curso = new Curso();
                curso.setId( rs.getLong("id") );
                curso.setNome( rs.getString("nome") );
                curso.setDescricao( rs.getString("descricao") );
                curso.setAtivo( rs.getBoolean("ativo") );
                curso.setInicio( rs.getDate("inicio").toLocalDate() );
                curso.setTermino( rs.getDate("termino").toLocalDate() );
                encontrados.add(curso);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encontrados;
    }

    @Override
    public void atualizar(long id, Curso curso) {

    }

    @Override
    public void remover(long id) {
        try (Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS)) {
            String sql = "DELETE FROM curso WHERE id = ?";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

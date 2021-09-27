package cursos.dio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {
    public static void main(String[] args) throws SQLException {
//        Create("C#", 55.1f);
//        System.out.println(Read(4));
//        System.out.println(Read());

//        Curso cursoAlterado = CursoDAO.Read(3);
//        cursoAlterado.setId(3);
//        cursoAlterado.setNome("Python");
//        cursoAlterado.setDuracaoHoras(25f);
//
//        CursoDAO.Update(cursoAlterado);

//        Delete(1);
    }

    //1. Create
    public static void Create(String curso, float duracaoHoras) {

        try (java.sql.Connection conn = Connection.connect()) {
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso);
            stmt.setFloat(2, duracaoHoras);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Curso: " + curso + " Inserido com sucesso! " + rowsAffected + " linhas foram adicionadas!");

        } catch (SQLException e){
            System.out.println("Data Input Error!");
        }
    }

    //2. Read
    public static Curso Read(int id) {
        Curso curso = new Curso();

        try (java.sql.Connection conn = Connection.connect()) {

            String sql = "SELECT * FROM curso WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getFloat("duracao_horas"));
            }

        } catch (SQLException e) {

        }

        return curso;
    }

    //2.1 Read (all data)
    public static ArrayList<Curso> Read() {
        ArrayList<Curso> listaCursos = new ArrayList<>();

        try (java.sql.Connection conn = Connection.connect()) {
            String sql = "SELECT * FROM curso";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs =  stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float duracaoHoras = rs.getFloat("duracao_horas");

                listaCursos.add(new Curso(id, nome, duracaoHoras));
            }

        } catch (SQLException e) {
            System.out.println("Error!!!!");
        }

        return listaCursos;
    }


    //3. Update
    public static void Update(Curso curso) {
        try(java.sql.Connection conn = Connection.connect()) {
            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, curso.getNome());
            stmt.setFloat(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Curso Alterado com Sucesso!!!");
            System.out.println(rowsAffected + " linha, foi alterada!");

        } catch (SQLException e) {
            System.out.println("Error!!!!");
        }
    }

    //4. Delete
    public static void Delete(int id) {
        try(java.sql.Connection conn = Connection.connect()) {
            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Value on ID: " + id + " has been deleted!!!");
            System.out.println(rowsAffected + " rows was affected!");
        } catch (SQLException e) {
            System.out.println("Error on delete attempt");
        }
    }

}

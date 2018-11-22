package br.csi.dao;


import br.csi.model.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GerenteDAO {

  
     
     
     
    public boolean update(Gerente gerente) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " UPDATE gerente"
                    + " SET nome = ?, email = ?, senha =? "
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, gerente.getNome());
            pre.setString(2, gerente.getEmail());
            pre.setString(3, gerente.getSenha());


            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Gerente read(String email, String senha) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM gerente"
                    + " WHERE email = ? AND senha=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, senha);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Gerente u = new Gerente();
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Gerente read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM gerente"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Gerente c = new Gerente();
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                

                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int create(String email, String senha) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " INSERT INTO gerente( email, senha) "
                    + " VALUES(?, ?);";
            PreparedStatement pre
                    = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pre.setString(1, email);
            pre.setString(2, senha);
            pre.execute();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();

            if (rs.getInt(1) > 0) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Gerente gerente) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            String sql = " INSERT INTO gerente(nome, email, senha) "
                    + " VALUES(?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, gerente.getNome());
            pre.setString(2, gerente.getEmail());
            pre.setString(3, gerente.getSenha());
           

            if (pre.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " DELETE FROM gerente"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Gerente> getGerentes() {
        ArrayList<Gerente> gerentes = new ArrayList<>();
        // Connection conn = new ConectaDB_Postgres().getConexao();
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM gerente");
            while (rs.next()) {
                Gerente ger = new Gerente();
                ger.setId(rs.getInt("id"));
                ger.setNome(rs.getString("nome"));
                ger.setEmail(rs.getString("email"));
                ger.setSenha(rs.getString("senha"));
                

                gerentes.add(ger);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gerentes;
    }

}

package br.csi.dao;

import br.csi.model.Motoboy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MotoboyDAO {

    public boolean update(Motoboy motoboy) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " UPDATE motoboy"
                    + " SET nome = ?,endereco = ?, placa =?"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, motoboy.getNome());

            pre.setString(2, motoboy.getEndereco());
            pre.setString(3, motoboy.getPlaca());

            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Motoboy read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM motoboy"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Motoboy c = new Motoboy();
                c.setNome("nome");
                c.setEmail("email");
                c.setEndereco(rs.getString("endereco"));
                c.setPlaca(rs.getString("placa"));

                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(Motoboy motoboy) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            String sql = " INSERT INTO motoboy(nome, email, endereco, placa) "
                    + " VALUES(?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, motoboy.getNome());
            pre.setString(2, motoboy.getEmail());

            pre.setString(3, motoboy.getEndereco());
            pre.setString(4, motoboy.getPlaca());

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
            String sql = " DELETE FROM motoboy"
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

    public ArrayList<Motoboy> getMotoboys() {
        ArrayList<Motoboy> motoboys = new ArrayList<>();

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM motoboy ");
            while (rs.next()) {
                Motoboy mot = new Motoboy();
                mot.setId(rs.getInt("id"));
                mot.setNome(rs.getString("nome"));
                mot.setEmail(rs.getString("email"));
                mot.setEndereco(rs.getString("endereco"));
                mot.setPlaca(rs.getString("placa"));

                motoboys.add(mot);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return motoboys;
    }

}

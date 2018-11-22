package br.csi.dao;

import br.csi.model.Cliente;
import br.csi.model.Motoboy;
import br.csi.model.Pedido;
import br.csi.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO {

    public static void main(String args[]) {
        Pedido u = new PedidoDAO().read(1);
        System.out.println("Nome cliente: " + u.getCliente().getNome());

    }

    public Pedido read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "select motoboy.nome as nomem, cliente.nome as nomec, produto.nome as nomep from motoboy, cliente, produto, pedido, pedido_produto \n"
                    + "	where motoboy.id = pedido.id_motoboy and cliente.id = pedido.id_cliente and produto.id = pedido.id_produto\n"
                    + "	and pedido.id = pedido_produto.id_pedido and pedido_produto.id_produto = produto.id and pedido.id = ?";
            
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                
                Cliente c = new Cliente();
                c.setNome(rs.getString("nomec"));

                Motoboy m = new Motoboy();
                m.setNome(rs.getString("nomem"));

              
                
                p.getCliente().getNome();
                p.getMotoboy().getNome();

                
                String sqlProdutos = "select produto.nome as nomep  from pedido,pedido_produto where pedido.id = ? AND pedido_produto.id_produto = produto.id";
            
                PreparedStatement preProdutos = conn.prepareStatement(sqlProdutos);
                preProdutos.setInt(1, id);
                ResultSet rsProdutos = preProdutos.executeQuery();
                
                ArrayList <Produto> listaProdutos = new ArrayList<>();

                    while (rsProdutos.next()) {
                        Produto pr = new Produto();
                        pr.setNome(rsProdutos.getString("nomep"));
                        
                        listaProdutos.add(pr);
                    
                    }
                    p.setProduto(listaProdutos);
                
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
     public boolean create(Pedido pedido) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            String sql = " select motoboy.nome as nomem, cliente.nome as nomec, produto.nome as nomep from motoboy, cliente, produto, pedido, pedido_produto \n"
                    + "	where motoboy.id = pedido.id_motoboy and cliente.id = pedido.id_cliente and produto.id = pedido.id_produto\n"
                    + "	and pedido.id = pedido_produto.id_pedido and pedido_produto.id_produto = produto.id and pedido.id = ?";
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
}

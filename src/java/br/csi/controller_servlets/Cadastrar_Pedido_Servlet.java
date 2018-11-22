
package br.csi.controller_servlets;

import br.csi.model.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Cadastrar_Pedido_Servlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(req.getParameter("id_cliente")));
    }
 
}
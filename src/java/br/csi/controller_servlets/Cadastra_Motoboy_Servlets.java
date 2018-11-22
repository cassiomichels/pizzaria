
package br.csi.controller_servlets;

import br.csi.dao.MotoboyDAO;
import br.csi.model.Motoboy;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "cadastro_motoboy")
public class Cadastra_Motoboy_Servlets extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
                System.out.println("Chamou GET ....");
        RequestDispatcher disp 
            = req.getRequestDispatcher("/WEB-INF/views/cadastro_motoboy.jsp");
            disp.forward(req, resp);
    }    
    
 @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String placa = req.getParameter("placa");
        Motoboy motoboy = new Motoboy(nome,email, endereco, placa);
        
        boolean retorno = new MotoboyDAO().create(motoboy);
        if(retorno){

            req.setAttribute("motoboy", nome);
 RequestDispatcher disp 
         = req.getRequestDispatcher("/WEB-INF/views/sucesso.jsp");
 disp.forward(req, resp);
           
            
        }else{            
resposta.println("<html><body><strong>ERRO</strong></body></html>");
        }
    }

    
    
}

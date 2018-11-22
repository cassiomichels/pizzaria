package br.csi.controller_servlets;


import br.csi.dao.GerenteDAO;
import br.csi.model.Gerente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "cadastro_gerente")
public class Cadastra_Gerente_Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
        RequestDispatcher disp 
            = req.getRequestDispatcher("/WEB-INF/views/cadastro_gerente.jsp");
            disp.forward(req, resp);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String email= req.getParameter("email");
        String senha= req.getParameter("senha");
        
       
        Gerente gerente = new Gerente(nome, email, senha);
        
        boolean retorno = new GerenteDAO().create(gerente);
        if(retorno){

            req.setAttribute("nome_gerente", nome);
 RequestDispatcher disp 
         = req.getRequestDispatcher("/WEB-INF/views/sucesso_gerente.jsp");
 disp.forward(req, resp);
          
            
        }else{            
resposta.println("<html><body><strong>ERRO</strong></body></html>");
        }
    }

    
    
}

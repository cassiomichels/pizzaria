package br.csi.controller_servlets;

import br.csi.dao.GerenteDAO;
import br.csi.dao.Login_GerenteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logar_gerente")
public class Login_Gerente_Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        System.err.println(email + " - " + senha);

        boolean autenticado
                = new Login_GerenteDAO().autenticar(email, senha);

        RequestDispatcher disp;

        if (autenticado) {
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado",
                    new GerenteDAO().read(email, senha));

            disp = req.getRequestDispatcher("/WEB-INF/views/pagina_inicial_gerente.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("mensagem", "Usuário ou Senha INCORRETOS, Tente novamente ou cadastre-se");
            disp = req.getRequestDispatcher("pagina_inicial_gerente.jsp");
            disp.forward(req, resp);
        }

    }

}

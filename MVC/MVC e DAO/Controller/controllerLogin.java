	package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jdbc.administradorDAO;
import Model.Administrador;

/**
 * Servlet implementation class controllerlogin
 */
@WebServlet(urlPatterns = {"/controllerLogin","/Login","/paginaLogin"})
public class controllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Administrador administrador = new Administrador();
	administradorDAO administradordao = new administradorDAO();
    
	
	
    public controllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//a string é igual a requisição
		String action = request.getServletPath();
		System.out.println(action);
		
		//se a action for igual a ação solicitada redireciona
		if(action.equals("/Login")) {
			
			Login(request,response);
			
		}
		if(action.equals("/paginaLogin")) {
			
			paginaLogin(request,response);
			
		}
		
		
	}

	
	protected void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//As variaveis cpf e senha são atribuidas a valores do html
		String Cpf = request.getParameter("Cpf");
		String Senha = request.getParameter("Senha");
		
		//Os valores são setados
		administrador.setCpf(Cpf);
		administrador.setSenha(Senha);
		
		//Se o resultado for verdadeiro vai para a tela de menu
		if(administradordao.loginAdm(administrador))
		{	
			response.sendRedirect("menuGeral.html");
		}
		else {
			//mostra a mensagem de erro
			request.setAttribute("erro", "Usuario ou senha invalidos");
			//vai para a pagina de login
			RequestDispatcher rd  = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);		
			}
		
		
	}

	protected void 	paginaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//redireciona para  a pagina de login
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
		
	}


}

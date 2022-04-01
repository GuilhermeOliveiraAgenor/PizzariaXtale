package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import Jdbc.administradorDAO;
import Model.Administrador;

/**
 * Servlet implementation class controlleradministrador
 */
@WebServlet(urlPatterns = {"/controllerAdministrador","/editarDados","/paginalterarDados","/paginaDados","/selecionarprodutosnoEmail","/selecionaringredientesnoEmail","/paginadoEmail"})
public class controllerAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Administrador administrador = new Administrador();
	administradorDAO administradordao = new administradorDAO();
       
    
    public controllerAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String action = request.getServletPath();//criar a string action
		System.out.println(action);
		
		
		//se a ação solicitada for igual a action vai ser redirecionada 		
		if(action.equals("/paginalterarDados")) {
			
			paginalterarDados(request,response);
			
		}
		if(action.equals("/paginaDados")) {
			
			paginaDados(request,response);
			
		}
		if(action.equals("/editarDados")) {
			
			editarDados(request,response);
			
		}	

		if(action.equals("/selecionarprodutosnoEmail")) {
			
			selecionarprodutosnoEmail(request,response);
			
		}
		
		if(action.equals("/selecionaringredientesnoEmail")) {
			
			selecionaringredientesnoEmail(request,response);
			
		}
		

		if(action.equals("/paginadoEmail")) {
			
			paginaEmail(request,response);
			
		}
		

		
		
	}
	protected void paginalterarDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//chama a função selecionar dados dos administrador
		administradordao.selecionarAdministrador(administrador);
		
		//passa os parametros html para as classes administrador
		request.setAttribute("Nome", administrador.getNome());
		request.setAttribute("Email", administrador.getEmail());
		request.setAttribute("Cpf", administrador.getCpf());
		request.setAttribute("Senha", administrador.getSenha());
		//redireciona para a pagina de meus dados
		RequestDispatcher rd = request.getRequestDispatcher("meusDados.jsp");
		rd.forward(request, response);
		
			
		}
	protected void paginaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		//chama a função selecionar dados dos administrador
		administradordao.selecionarAdministrador(administrador);


		//passa os parametros html para as classes administrador
		request.setAttribute("Nome", administrador.getNome());
		request.setAttribute("Email", administrador.getEmail());
		request.setAttribute("Cpf", administrador.getCpf());
		request.setAttribute("Senha", administrador.getSenha());
		//redireciona para a pagina de alterar dados
		RequestDispatcher rd = request.getRequestDispatcher("alterarDados.jsp");
		rd.forward(request, response);
		
			
		}
		protected void editarDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//passa os parametros html para as classes administrador
			administrador.setNome(request.getParameter("Nome"));
			administrador.setEmail(request.getParameter("Email"));
			administrador.setSenha(request.getParameter("Senha"));

			//chamar a função de alterar os dados do administrador
			administradordao.alterardadosAdm(administrador);
			
			//redireciona para action 
			response.sendRedirect("paginalterarDados");
			
		}


		protected void selecionarprodutosnoEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//chama a função selecionar produto 
			String result = administradordao.selecionarProduto(administrador);
			
			//a string result vai retornar a mensagem 
			//o attribute erro vai receber a mensagem
			request.setAttribute("erro", result);
			
			//redireciona para a página paginadoemail.jsp
			RequestDispatcher rd  = request.getRequestDispatcher("paginadoEmail.jsp");
			rd.include(request, response);

			
			
				
		}

		protected void selecionaringredientesnoEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			//chama a função selecionar ingrediente		
			String result = administradordao.selecionarIngredientes(administrador);
			
			//a string result vai retornar a mensagem 
			//o attribute erro vai receber a mensagem
			request.setAttribute("erro", result);
			
			//redireciona para a página paginadoemail.jsp
			RequestDispatcher rd  = request.getRequestDispatcher("paginadoEmail.jsp");
			rd.include(request, response);
			
			}
		

		protected void paginaEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//redireciona para a página paginadoemail.jsp
			RequestDispatcher rd = request.getRequestDispatcher("paginadoEmail.jsp");
			rd.forward(request, response);
		}
		

	}

	


package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Jdbc.ingredientesDAO;
import Model.Ingredientes;
import Model.Pizza;

/**
 * Servlet implementation class controlleringredientes
 */
@WebServlet(urlPatterns = { "/controllerIngredientes", "/paginacadastrarIngredientes", "/inserirIngredientes","/listarIngredientes","/selecionarIngrediente","/editarIngrediente","/excluirIngrediente"})
public class controllerIngredientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Ingredientes ingredientes = new Ingredientes();
	ingredientesDAO ingredientesdao = new ingredientesDAO();

	public controllerIngredientes() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();//criar a string action
		System.out.println(action);
		
		//se a ação solicitada for igual a action vai ser redirecionada
		
		if (action.equals("/paginacadastrarIngredientes")) {

			paginacadastrarIngredientes(request, response);

		}
		if (action.equals("/inserirIngredientes")) {

			inserirIngredientes(request, response);

		}
		if (action.equals("/listarIngredientes")) {

			listarIngredientes(request, response);

		}
		if (action.equals("/selecionarIngrediente")) {

			selecionarIngrediente(request, response);

		}
		if (action.equals("/editarIngrediente")) {

			editarIngrediente(request, response);
	
		}
		if (action.equals("/excluirIngrediente")) {

			excluirIngrediente(request, response);
	
		}

	}

	protected void paginacadastrarIngredientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//redireciona para a pagina cadastroingrediente.jsp
		
		RequestDispatcher rd = request.getRequestDispatcher("cadastroIngrediente.jsp");
		rd.forward(request, response);

	}

	protected void inserirIngredientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		//passa o valor	do html para a classe ingrediente
		
			ingredientes.setNome(request.getParameter("Nome"));
			ingredientes.setUnidadedemedida(request.getParameter("Unidadedemedida"));
			ingredientes.setQuantidade(Integer.parseInt(request.getParameter("Quantidade")));
			
			//a string result chama a função inseriringrediente
			String result = ingredientesdao.inserirIngrediente(ingredientes);
			

			//a string result vai retornar a mensagem 
			//o attribute erro vai receber a mensagem
			request.setAttribute("erro", result);
			//redireciona para cadastroingrediente.jsp
			RequestDispatcher rd  = request.getRequestDispatcher("cadastroIngrediente.jsp");
			rd.include(request, response);
			
			
	}

	protected void listarIngredientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//chama função selecionaringrediente com o array
		ArrayList<Ingredientes> listarIngredientes = ingredientesdao.selecionarIngredientes();
		
		//chama o listaringrediente do array

		request.setAttribute("listarIngredientes", listarIngredientes);
		//chama a pagina alteraringrediente.jsp

		RequestDispatcher rd = request.getRequestDispatcher("alterarIngrediente.jsp");
		rd.forward(request, response);
	}
	protected void selecionarIngrediente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//chama função selecionaringrediente com o array
		ArrayList<Ingredientes> listarIngrediente = ingredientesdao.selecionarIngredientes();
		RequestDispatcher rd = request.getRequestDispatcher("alterarIngrediente.jsp");
	
		//passa o parametro html para o idingrediente

		int idIngrediente = (Integer.parseInt(request.getParameter("idIngrediente")));
		//o id ingrediente é setado pelo  idIngrediente
		ingredientes.setIdIngrediente(idIngrediente);
		
		//chama a função selecionaringredientecodigo
		ingredientesdao.selecionaringredienteCodigo(ingredientes);
		//os valores do html sao passados para a classe

		request.setAttribute("listarIngredientes", listarIngrediente);
		request.setAttribute("idIngrediente", ingredientes.getIdIngrediente());
		request.setAttribute("Nome", ingredientes.getNome());
		request.setAttribute("Unidadedemedida", ingredientes.getUnidadedemedida());
		request.setAttribute("Quantidade", ingredientes.getQuantidade());
		request.setAttribute("Disponivel", ingredientes.getDisponivel());
		//chama a pagina alteraringrediente.jsp
		rd.forward(request, response);

	}
	
	protected void editarIngrediente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//chama a função selecionaringrediente com o array
		ArrayList<Ingredientes> listarIngrediente = ingredientesdao.selecionarIngredientes();
		
		RequestDispatcher rd = request.getRequestDispatcher("mensagemIngrediente.jsp");
		
		//os campos são passados do html para a classe ingrediente
		ingredientes.setIdIngrediente(Integer.parseInt(request.getParameter("idIngrediente")));
			ingredientes.setNome(request.getParameter("Nome"));
			ingredientes.setQuantidade(Integer.parseInt(request.getParameter("Quantidade")));
			ingredientes.setUnidadedemedida(request.getParameter("Unidadedemedida"));
			ingredientes.setDisponivel(request.getParameter("Disponivel"));
			
			//a string result chama a função alteraringrediente
			String result = ingredientesdao.alterarIngredientes(ingredientes);
			//chama o listaringredientes
			request.setAttribute("listarIngredientes", listarIngrediente);
			

			//a string result vai retornar a mensagem 
			//o attribute erro vai receber a mensagem
			request.setAttribute("erro", result);
			//chama a página de mensagemingrediente.jsp
			rd.include(request, response);
				
		
	}
	protected void excluirIngrediente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//o valor do idingrediente é passado para a variavel que veio do html
			int idIngrediente = (Integer.parseInt(request.getParameter("idIngrediente")));
			
			//o idingrediente é passado para a classe
			ingredientes.setIdIngrediente(idIngrediente);
			
			//chama a função excluiringredientes
			ingredientesdao.excluirIngredientes(ingredientes);
			
			//redireciona para action listarcategoria
			response.sendRedirect("listarIngredientes");
		
	}


}

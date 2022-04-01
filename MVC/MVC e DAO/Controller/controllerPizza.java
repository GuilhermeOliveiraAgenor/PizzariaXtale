package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jdbc.pizzaDAO;
import Model.Categoria;
import Model.Pizza;

/**
 * Servlet implementation class controllerpizza
 */
@WebServlet(urlPatterns = { "/controllerPizza", "/inserirPizza","/paginacadastroPizza","/paginalterarPizza","/selecionarpizzAlterar","/editarPizza","/excluirPizza"})
public class controllerPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Pizza pizza = new Pizza();
	pizzaDAO pizzadao = new pizzaDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controllerPizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//a string vai receber a requisição
		String action = request.getServletPath();
		System.out.println(action);
		
		//se a action for igual a requisição redireciona
		if(action.equals("/inserirPizza")) {
			
			inserirPizza(request,response);
			
	}
		if(action.equals("/paginacadastroPizza")) {
			
			paginacadastrarPizza(request,response);
			
	}
		if(action.equals("/paginalterarPizza")) {
			
			paginalterarPizza(request,response);
			
	}
		if(action.equals("/selecionarpizzAlterar")) {
			
		
			selecionarpizzAlterar(request,response);
		
		}
		if(action.equals("/editarPizza")) {
			
			
			editarPizza(request,response);
		
		}
		if(action.equals("/excluirPizza")) {
		
			excluirPizza(request, response);
		
		}
	}
		

	protected void inserirPizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//parametros do html são passados para a classe
		pizza.setNome(request.getParameter("Nome"));
		pizza.setPreco(Float.parseFloat(request.getParameter("Preco")));
		pizza.setTamanhopizza(request.getParameter("Tamanhopizza"));
		
		//a string result chama a função inserir pizza
		String result = pizzadao.inserirpizzAdm(pizza);
		
		//chama a mensagem
		request.setAttribute("erro", result);
		
		//redireciona para a pagina
		RequestDispatcher rd  = request.getRequestDispatcher("cadastrarPizza.jsp");
		rd.include(request, response);
		

	}
	protected void paginacadastrarPizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//redireciona a pagina
		RequestDispatcher rd = request.getRequestDispatcher("cadastrarPizza.jsp");
		rd.forward(request, response);

	}
	
	protected void paginalterarPizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//cria um array com a função selecionarpizza
		ArrayList<Pizza> listarPizza = pizzadao.selecionarPizza();
		
		//chama a lista de pizza  na pagiina
		request.setAttribute("listarPizza", listarPizza);
		//redireciona para a página
		RequestDispatcher rd = request.getRequestDispatcher("alterarPizza.jsp");
		rd.forward(request, response);
		

	}
	protected void selecionarpizzAlterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//criar um array com a função selecionarpizza
		ArrayList<Pizza> listarPizza = pizzadao.selecionarPizza();
		RequestDispatcher rd = request.getRequestDispatcher("alterarPizza.jsp");
		
		//a variavel idpizza recebe o valor do html
		int Idpizza = (Integer.parseInt(request.getParameter("Idpizza")));
	
		//o id pizza recebe o valor da variavel
		pizza.setIdpizza(Idpizza);
		
		
		//chama a função selecionarpizzacodigo
		pizzadao.selecionarpizzaCodigo(pizza);
		
		//lista de pizzas
		request.setAttribute("listarPizza", listarPizza);
		//os valores do html são passados para a classe
		request.setAttribute("Idpizza", pizza.getIdpizza());
		request.setAttribute("Nome", pizza.getNome());
		request.setAttribute("Preco", pizza.getPreco());
		request.setAttribute("Tamanhopizza", pizza.getTamanhopizza());
		request.setAttribute("Disponivel", pizza.getDisponivel());
		//redireciona para a pagina alterarpizza.jsp
		rd.forward(request, response);
	}
	protected void editarPizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//cria um array pizza
		ArrayList<Pizza> listarPizza = pizzadao.selecionarPizza();
		//os parametros do html sao passados para a classe
		pizza.setIdpizza(Integer.parseInt(request.getParameter("Idpizza")));
		pizza.setNome(request.getParameter("Nome"));
		pizza.setPreco(Float.parseFloat(request.getParameter("Preco")));
		pizza.setTamanhopizza(request.getParameter("Tamanhopizza"));
		pizza.setDisponivel(request.getParameter("Disponivel"));
		
		//a string result chama a funcao alterarpizzadm
		String result = pizzadao.alterarpizzAdm(pizza);

		//chama o erro
		request.setAttribute("erro", result);
		RequestDispatcher rd = request.getRequestDispatcher("Tela.jsp");
		//chama a lista de pizza
		request.setAttribute("listarPizza", listarPizza);
		//redireciona para a pagina tela.jsp
		rd.include(request, response);
				
	}
	protected void excluirPizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//a variavel id pizza recebe o valor do html
		int Idpizza = (Integer.parseInt(request.getParameter("Idpizza")));
		//a classe recebe o valor da variavel
		pizza.setIdpizza(Idpizza);
		//chama a função excluirpizzadm
		pizzadao.excluirpizzAdm(pizza);
		//redireciona para a pagina alterar pizza
		response.sendRedirect("paginalterarPizza");
	
	}

}

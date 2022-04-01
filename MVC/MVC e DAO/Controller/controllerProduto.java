	package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jdbc.categoriaDAO;
import Jdbc.produtoDAO;
import Model.Produto;
import Model.Categoria;

/**
 * Servlet implementation class controllerprodu
 */
@WebServlet(urlPatterns = { "/controllerProduto", "/paginacadastroProduto", "/inserirProduto","/listarProduto","/paginAlterar","/selecionarProduto","/excluirProduto","/editarProduto","/listarprodutoEscolher","/selecionarprodutoAlterar"})
public class controllerProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Produto produto = new Produto();
	produtoDAO produtodao = new produtoDAO();
	Categoria categoria = new Categoria();
	categoriaDAO categoriadao = new categoriaDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controllerProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//a string vai receber a requisição
				String action = request.getServletPath();
				System.out.println(action);
				//se a action for igual a requisição redireciona
		
		if (action.equals("/paginacadastroProduto")) {

			paginacadastroProduto(request, response);

		}
		if (action.equals("/inserirProduto")) {

			inserirProduto(request, response);

		}
		if(action.equals("/listarProduto")) {
					
			listarProduto(request,response);
			
		}
		if(action.equals("/paginAlterar")) {
			
			paginAlterar(request,response);
		}
		if(action.equals("/selecionarProduto")) {
			
			selecionarprodutoPagina(request,response);
		}
		if(action.equals("/excluirProduto")) {
			
			excluirProduto(request,response);
			
		}
		if(action.equals("/editarProduto")) {
			
			try {
			editarProduto(request,response);
			} catch (Exception e) {
				
			}
			
		}
		if(action.equals("/listarprodutoEscolher")) {
			
			listarprodutoEscolher(request,response);
			
		}
		if(action.equals("/selecionarprodutoAlterar")) {
			
			listarprodutoAlterar(request,response);
			
		}
		
				

	}

	protected void paginacadastroProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//cria um array com a função selecionarcategoria
		ArrayList<Categoria> listarCategoria = categoriadao.selecionarCategoria();
		//chama a lista de categoria
		request.setAttribute("listarCategoria", listarCategoria);
		//redireciona para a pagina de cadastro de produto
		RequestDispatcher rd = request.getRequestDispatcher("cadastrarProduto.jsp");
		rd.forward(request, response);
		
		
	}
	
	
	protected void listarprodutoAlterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//a variavel recebe o valor do html
		int Idproduto = (Integer.parseInt(request.getParameter("Idproduto")));
		//a classe recebe a variável
		produto.setIdproduto(Idproduto);
		//chama a funcao selecionarprodutocodigo
		produtodao.selecionarprodutoCodigo(produto);
		//os parametros são passadaos do html para a classe
		request.setAttribute("Idproduto",produto.getIdproduto());
		request.setAttribute("Nome", produto.getNome());
		request.setAttribute("Preco", produto.getPreco());
		request.setAttribute("Categoria", produto.getCategoria());
		request.setAttribute("Estoque", produto.getEstoque());
		
		//redireciona para a pagina
		RequestDispatcher rd = request.getRequestDispatcher("cadastrarProduto.jsp");
		rd.forward(request, response);
		
		
	}
	
	
	protected void paginAlterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//cria lista com a funcao selecionarproduto
		ArrayList<Produto> listarProdutos = produtodao.selecionarProduto();
		//Enviar lista a pagina
		//chama a lista de produtos
		request.setAttribute("listarprodutoalterar", listarProdutos);
		//redireciona para a pagina alterar produto
		RequestDispatcher rd =  request.getRequestDispatcher("alterarProduto.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void excluirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//a variavel id produto recebe o valor do html
		int Idproduto = (Integer.parseInt(request.getParameter("Idproduto")));
		//o valor do idproduto é passado para a classe
		produto.setIdproduto(Idproduto);
		//chama a funcao excluir produto
		produtodao.excluirProduto(produto);
		//redireciona para ação listar produto
		response.sendRedirect("listarProduto");
		

	}
	
	
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,Exception {
		
		//criar um array com a funcao selecionarproduto
		ArrayList<Produto> listarProdutos = produtodao.selecionarProduto();
		RequestDispatcher rd =  request.getRequestDispatcher("alterarProduto.jsp");
		//passa os parametros do html para a classe
		produto.setIdproduto(Integer.parseInt(request.getParameter("Idproduto")));
		produto.setNome(request.getParameter("Nome"));
		produto.setPreco(Float.parseFloat(request.getParameter("Preco")));
		produto.setCategoria(Integer.parseInt(request.getParameter("Categoria")));
		produto.setEstoque(Integer.parseInt(request.getParameter("Estoque")));
		
		//a string result chama a funcao alterar produto
		String result = produtodao.alterarProduto(produto);
		
		//chama a lista de produto
		request.setAttribute("listarprodutoAlterar", listarProdutos);
		//chama a mensagem
		request.setAttribute("erro", result);
		rd.include(request, response);
		
		
	}
	
	
	
	protected void selecionarprodutoPagina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//cria o array com a funcao selecionar produto
		ArrayList<Produto> listarProduto = produtodao.selecionarProduto();
		RequestDispatcher rd =  request.getRequestDispatcher("alterarProduto.jsp");
		// a variavel recebe o valor do html
		int Idproduto = (Integer.parseInt(request.getParameter("Idproduto")));
		//o idproduto recebe a variavel
		produto.setIdproduto(Idproduto);
		//chama a funcao selecionar produto codigo
		produtodao.selecionarprodutoCodigo(produto);
		
		//chama a lista de produto
		request.setAttribute("listarprodutoAlterar", listarProduto);
		//passa os valores do html para a classe
		request.setAttribute("Idproduto",produto.getIdproduto());
		request.setAttribute("Nome", produto.getNome());
		request.setAttribute("Preco", produto.getPreco());
		request.setAttribute("Categoria", produto.getCategoria());
		request.setAttribute("Estoque", produto.getEstoque());
		//redireciona para a pagina
		rd.forward(request, response);

		

	}

	protected void inserirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//cria um array com a funcao selecionarcategoria
		ArrayList<Categoria> listarCategoria = categoriadao.selecionarCategoria();
		RequestDispatcher rd = request.getRequestDispatcher("cadastrarProduto.jsp");
		//os valores do html sao passados para a classe
		produto.setNome(request.getParameter("Nome"));
		produto.setPreco(Float.parseFloat(request.getParameter("Preco")));
		produto.setCategoria(Integer.parseInt(request.getParameter("Categoria")));
		produto.setEstoque(Integer.parseInt(request.getParameter("Estoque")));

		//o result chama a funcao inserirproduto
	   String result = produtodao.inserirProduto(produto);
		
	   //chama a lista de categoria
	   request.setAttribute("listarCategoria", listarCategoria);
	   //chama a mensagem
	   request.setAttribute("erro", result);
		//redireciona para o inserirproduto
	   rd.include(request, response);
	   
	   
		}
	
	
	
	
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//cria um array com a funcao seleciona produto
		ArrayList<Produto> listarProdutos = produtodao.selecionarProduto();
		//Enviar lista a pagina
		//chama a lista de produtos
		request.setAttribute("listar", listarProdutos);
		RequestDispatcher rd =  request.getRequestDispatcher("listarProdutos.jsp");
		//redireciona para a lista de produto
		rd.forward(request, response);
		
		
	}
	
	protected void listarprodutoEscolher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//a variavel id produto recebe os valores do html
		int Idproduto = (Integer.parseInt(request.getParameter("Idproduto")));
		//a variavel do idproduto é passada para a classe
		produto.setIdproduto(Idproduto);
		//chama a funcao selecionarprodutocodigo
		produtodao.selecionarprodutoCodigo(produto);
		//os valores do html sao passados para a classe
		request.setAttribute("Idproduto",produto.getIdproduto());
		request.setAttribute("Nome", produto.getNome());
		request.setAttribute("Preco", produto.getPreco());
		request.setAttribute("Categoria", produto.getCategoria());
		request.setAttribute("Estoque", produto.getEstoque());
		//redireciona para a pagina de alterarproduto
		RequestDispatcher rd =  request.getRequestDispatcher("alterarProduto.jsp");
		rd.forward(request, response);
		
	}
	
	
	

}

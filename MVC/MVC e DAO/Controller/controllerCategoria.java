package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jdbc.categoriaDAO;
import Model.Categoria;

/**
 * Servlet implementation class controllercategoria
 */
@WebServlet(urlPatterns = {"/controllerCategoria","/paginacadastrarCategoria","/inserirCategoria","/listarCategoria","/selecionarcategoriAlterar","/editarCategoria","/excluirCategoria"})
public class controllerCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Categoria categoria = new Categoria();
	categoriaDAO categoriadao = new categoriaDAO();
       
    
    public controllerCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();//criar a string action
		System.out.println(action);
		
		//se a ação solicitada for igual a action vai ser redirecionada 
		if(action.equals("/paginacadastrarCategoria")) {
			
			paginacadastrarCategoria(request,response);
			
		}

		if(action.equals("/inserirCategoria")) {
			
			inserirCategoria(request,response);
			
		}

		if(action.equals("/listarCategoria")) {
			
			listarCategoria(request,response);
			
		}
		if(action.equals("/selecionarcategoriAlterar")) {
			
			selecionarcategoriAlterar(request,response);
			
		}
		if(action.equals("/editarCategoria")) {
			
			editarCategoria(request,response);
			
		}
		if(action.equals("/excluirCategoria")) {
			
			excluirCategoria(request,response);
			
		}

		
		
	}
	protected void paginacadastrarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//redireciona para a pagina cadastrocategoria.jsp
		RequestDispatcher rd = request.getRequestDispatcher("cadastroCategoria.jsp");
		rd.forward(request, response);
		
	}

	protected void inserirCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//passa o valor	do html para a classe categoria
		categoria.setNome(request.getParameter("Nome"));

		//a string result chama a função inserircategoria
		String result = categoriadao.inserirCategoria(categoria);


		//a string result vai retornar a mensagem 
		//o attribute erro vai receber a mensagem
		request.setAttribute("erro", result);	
		//redireciona para cadastrocategoria.jsp
		RequestDispatcher rd  = request.getRequestDispatcher("cadastroCategoria.jsp");
		rd.forward(request, response);
		
		
	}

	protected void listarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//chama função selecionarcategoria com o array
		ArrayList<Categoria> listarCategoria = categoriadao.selecionarCategoria();
		
		//chama o listarcategoria do array
		request.setAttribute("listarCategoria", listarCategoria);
		//chama a pagina listarcategoria.jsp
		RequestDispatcher rd = request.getRequestDispatcher("listarCategoria.jsp");
		rd.forward(request, response);
	
	}
	protected void selecionarcategoriAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//passa o parametro html para o idcategoria
		int idCategoria = (Integer.parseInt(request.getParameter("idCategoria")));
		
		//o id categoria é setado pelo  idcategoria
		categoria.setIdCategoria(idCategoria);
		
		//chamar a função selecionarcategorianocodigo
		categoriadao.selecionarcategorianoCodigo(categoria);
		
		//os valores do html sao passados para a classe
		request.setAttribute("idCategoria", categoria.getIdCategoria());
		request.setAttribute("Nome", categoria.getNome());
		
		//redireciona para a pagina alterar categoria
		RequestDispatcher rd = request.getRequestDispatcher("alterarCategoria.jsp");
		rd.forward(request, response);
	}
		protected void editarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//chama a função selecionarcategoria com o array
			ArrayList<Categoria> listarCategoria = categoriadao.selecionarCategoria();
			
			//chama o listarcategoria
			request.setAttribute("listarCategoria", listarCategoria);
			
			//os campos são passados do html para a classe categoria
			categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
			categoria.setNome(request.getParameter("Nome"));
			
			//a string result chama a função alterarcategoria
			String result = categoriadao.alterarCategoria(categoria);
			

			//a string result vai retornar a mensagem 
			//o attribute erro vai receber a mensagem
			request.setAttribute("erro", result);
			
			//redireciona para a pagina de alterarcategoria.jsp
			RequestDispatcher rd  = request.getRequestDispatcher("alterarCategoria.jsp");
			rd.include(request, response);
			
		
		
		}
		protected void excluirCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//chama a função selecionarcategoria com o array
			ArrayList<Categoria> listarCategoria = categoriadao.selecionarCategoria();
			
			//chama o listar categoria do array da pagina
			request.setAttribute("listarCategoria", listarCategoria);

			//o valor do idCategoria é passado para a variavel que veio do html
			int idCategoria = (Integer.parseInt(request.getParameter("idCategoria")));
			
			//o idcategoria é passado para a classe
			categoria.setIdCategoria(idCategoria);
			
			//chama a função excluircategoria
			categoriadao.excluirCategoria(categoria);
			
			//redireciona para action listarcategoria
			response.sendRedirect("listarCategoria");
			
		}

	
	
}

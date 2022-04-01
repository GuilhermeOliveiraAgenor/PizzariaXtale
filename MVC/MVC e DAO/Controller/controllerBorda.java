package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jdbc.bordaDAO;
import Model.Borda;

/**
 * Servlet implementation class controllerborda
 */
@WebServlet(urlPatterns = {"/controllerBorda","/paginacadastroBorda","/inserirBorda","/listarBorda","/editarBorda","/selecionarbordAlterar","/excluirBorda"})
public class controllerBorda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Borda borda = new Borda();
	bordaDAO bordadao = new bordaDAO();
   
    public controllerBorda() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action = request.getServletPath();//criar a string action
		System.out.println(action);
		
		//se a ação solicitada for igual a action vai ser redirecionada 		
		if(action.equals("/paginacadastroBorda")) {
			
			paginacadastrarBorda(request,response);
			
		}
		if(action.equals("/inserirBorda")) {
			
			inserirBorda(request,response);
			
		}
		if(action.equals("/listarBorda")) {
			
			listarBorda(request,response);
		}
		if(action.equals("/editarBorda")) {
			
			editarBorda(request,response);
		}
		if(action.equals("/selecionarbordAlterar")) {
			
			selecionarbordAlterar(request,response);
		}
		if(action.equals("/excluirBorda")) {
			
			excluirBorda(request,response);
		}
		
		
	}
	
	protected void paginacadastrarBorda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//redireciona para a pagina cadastrarborda.jsp 		
	RequestDispatcher rd = request.getRequestDispatcher("cadastrarBorda.jsp");
	rd.forward(request, response);
	
	
	}
	
	protected void inserirBorda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//os parametros do  html são passados para a classe borda
		borda.setNomeborda(request.getParameter("Nome"));
		borda.setPreco(Float.parseFloat(request.getParameter("Preco")));
		

		//chama a função selecionar inserirbordadm
		String result = bordadao.inserirbordAdm(borda);
		
		//a string result vai retornar a mensagem 
		//o attribute erro vai receber a mensagem
		request.setAttribute("erro", result);
		
		//redireciona para a pagina cadastrarborda.jsp
		RequestDispatcher rd  = request.getRequestDispatcher("cadastrarBorda.jsp");
		rd.include(request, response);
		
		
	}
	protected void listarBorda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//cria o array com a função selecionarborda
	ArrayList<Borda> listarBorda = bordadao.selecionarBorda(); 
	
	//Enviar lista a pagina
	request.setAttribute("listarBorda", listarBorda);
	//redireciona para a pagina listarborda.jsp
	RequestDispatcher rd =  request.getRequestDispatcher("listarBorda.jsp");
	rd.forward(request, response);
	
	}
	protected void editarBorda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//os parametros do  html são passados para a classe borda
		borda.setIdborda(Integer.parseInt(request.getParameter("Idborda")));
		borda.setNomeborda(request.getParameter("Nome"));
		borda.setPreco(Float.parseFloat(request.getParameter("Preco")));
		
		//chama a funcao alterar borda
		String result = bordadao.alterarbordAdm(borda);
		

		//a string result vai retornar a mensagem 
		//o attribute erro vai receber a mensagem
		request.setAttribute("erro", result);
		//redireciona para a pagina alterarborda.jsp
		RequestDispatcher rd  = request.getRequestDispatcher("alterarBorda.jsp");
		rd.include(request, response);
		
		
		}

	protected void selecionarbordAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//a variavel idborda é passada para valor do html
		int Idborda = (Integer.parseInt(request.getParameter("Idborda")));
		
		//o id borda é setado pela classe borda
		borda.setIdborda(Idborda);
		
		//chama a função selecionar borda código
		bordadao.selecionarbordaCodigo(borda);
		
		//os parametros do html são passados para a classe
		request.setAttribute("Idborda",borda.getIdborda());
		request.setAttribute("Nome", borda.getNomeborda());
		request.setAttribute("Preco", borda.getPreco());
		//redireciona para a pagina de alterarborda.jsp
		RequestDispatcher rd = request.getRequestDispatcher("alterarBorda.jsp");
		rd.forward(request, response);
		
		
		}
	protected void excluirBorda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//criar a função selecionarborda com o array
		ArrayList<Borda> listarborda = bordadao.selecionarBorda(); 
	

		//a variavel idborda é passada para valor do html
		int Idborda = Integer.parseInt(request.getParameter("Idborda"));
		
		//o id borda é passado na classe borda
		borda.setIdborda(Idborda);
		
		//chama a função excluir borda
		bordadao.excluirbordAdm(borda);
		
		//redireciona para a action listarborda
		response.sendRedirect("listarBorda");
		
		}

}

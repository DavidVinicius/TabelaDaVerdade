package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Historico;
import truthTable.TruthTable;

/**
 * Servlet implementation class Entrada
 */
@WebServlet("/entrada")
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Entrada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Passou aqui");		
		String expression = request.getParameter("expression");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TabelaVerdadeWeb");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Historico hist = new Historico();
		hist.setExpression(expression);
		
		//Historico historico = entityManager.find(Historico.class, 1);
		
		entityManager.getTransaction().begin();
		entityManager.persist(hist);		
		entityManager.getTransaction().commit();
				
		entityManager.close();
		entityManagerFactory.close();
				
		TruthTable truthTable = new TruthTable(expression);	
		request.setAttribute("truthTable", truthTable);
		
		RequestDispatcher rd = request.getRequestDispatcher("/resultado.jsp");		
		rd.forward(request, response);
	}

}

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.transform.Transformers;

import model.Historico;

/**
 * Servlet implementation class Historico
 */
@WebServlet("/historico")
public class HistoricoExpressions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoricoExpressions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TabelaVerdadeWeb");		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
							
		List<Historico> results = (List<Historico>) entityManager.createNativeQuery("select * from historico;", Historico.class).getResultList();
			
		System.out.println("Total Number Of Records : "+results.size());
		
		for(Historico hist: results) {
			System.out.println(hist.getExpression());
		}
	    		
				
		entityManager.close();
		entityManagerFactory.close();
		
		
		request.setAttribute("historico", results);
		
		RequestDispatcher rd = request.getRequestDispatcher("/historico.jsp");		
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

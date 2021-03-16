package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import dao.HistoricoDAO;

/**
 * Servlet Filter implementation class SaveExpressionFilter
 */
@WebFilter("/entrada")
public class SaveExpressionFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		String expression = request.getParameter("expression");
							
		HistoricoDAO histDAO = new HistoricoDAO();
		histDAO.saveExpression(expression);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}

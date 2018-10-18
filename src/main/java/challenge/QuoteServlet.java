package main.java.challenge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		try {
			Quote quote;
			String pathInfo = req.getPathInfo();
						
			if (pathInfo == null || pathInfo.equals("/")) {
				quote = new QuoteDao().getQuote();
			} else {
				String actor = pathInfo.split("/")[1];
				quote = new QuoteDao().getQuoteByActor(actor);
			}		
					
			//resp.setContentType("application/json");
			//resp.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			out.print(mapper.writeValueAsString(quote));
			//out.flush();
		
			//resp.setStatus(HttpServletResponse.sc);
		} catch (Exception e) {
			//e.printStackTrace();
			out.println(e.getMessage());
			//resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		
	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientWS_C.CountryConvertor;


/**
 * Servlet implementation class Country_servlet
 */
@WebServlet("/Country_servlet")
public class Country_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Country_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		//System.out.printf("Entro");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				CountryConvertor client = new CountryConvertor();

				String value = request.getParameter("value").toString();
				String type = request.getParameter("type").toString();
				PrintWriter out = response.getWriter();
				if(value.equals("")){
					out.write("error: Please, provide a value!");  
				}else{
					String result = "";
					if(type.equals("number")) {
						result = client.convert2word(value);
					}
					else if(type.equals("price")){
						result = "(+" + client.getCountryPhoneCodeByISOCode(value) + "), " + client.code2word(value);
					}
					/*else if(type.equals("other")){
						result = client.code2word(value);
						
					}*/
					
					//result = client.code2word(value);
					out.write(result); 			
				}
							 
				out.flush();
			    out.close();
	}

}






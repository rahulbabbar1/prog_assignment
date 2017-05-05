package com.assignement.java;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgramServlet
 */
@WebServlet("/ProgramServlet")
public class ProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String prefix = request.getParameter("prefix");
		
		String filename = "C:\\Users\\rahul\\workspace\\java_assign\\alice30.txt";
		HashMap <String, Integer> wordMap = JavaAssignment.getWordMap(filename);
		
		String result = JavaAssignment.getListWithPrefix(wordMap,prefix);
		
		request.setAttribute("message", "<h2>The words with prefix \"" + prefix + "\" and their corresponding counts are <br> </h2>" + result);
		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
	}

}

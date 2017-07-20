package team.aab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import team.aab.bean.AlumniBean;
import team.aab.service.AlumniService;
import team.aab.service.TouristService;

public class TouristServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String doWhat = request.getParameter("dowhat");
		AlumniBean alumni = new AlumniBean();
		Map alumniMap = request.getParameterMap();
		TouristService touristService = new TouristService();
		
		if("select".equals(doWhat)){
			try {
				BeanUtils.populate(alumni, alumniMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<AlumniBean> list = touristService.select(alumni);
            request.setAttribute("aluList", list);
            request.getRequestDispatcher("tourist/touristselectresult.jsp").forward(request, response);
		}
	}

}

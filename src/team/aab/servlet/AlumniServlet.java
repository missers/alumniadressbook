package team.aab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
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
import team.aab.util.UserException;

public class AlumniServlet extends HttpServlet {

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
		AlumniService alumniService = new AlumniService();
		HttpSession session = request.getSession();
		
		if("login".equals(doWhat)){
			try{
				BeanUtils.populate(alumni, alumniMap);
				alumniService.login(alumni);
				request.getRequestDispatcher("alumni/alumnimain.jsp").forward(request, response);
				session.setAttribute("myusername", alumni.getUsername());
			}catch(Exception e){
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("alumni/alumnilogin.jsp").forward(request, response);
			}
			
		}else if("signup".equals(doWhat)){
			try{
				BeanUtils.populate(alumni, alumniMap);
				alumniService.checkBlank(alumni);
				alumniService.checkRepeat(alumni);
				alumniService.signUp(alumni);
				request.getRequestDispatcher("alumni/alumnisignupsucess.jsp").forward(request, response);
			}catch(Exception e){
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("alumni/alumnisignup.jsp").forward(request, response);
			}
		}else if("showall".equals(doWhat)){
			List<AlumniBean> list = alumniService.showAll();
            request.setAttribute("aluList", list);
            request.getRequestDispatcher("alumni/alumniall.jsp").forward(request, response);
		}else if("select".equals(doWhat)){
			try {
				BeanUtils.populate(alumni, alumniMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<AlumniBean> list = alumniService.select(alumni);
            request.setAttribute("aluList", list);
            request.getRequestDispatcher("alumni/alumniselectresult.jsp").forward(request, response);
		}else if("modify".equals(doWhat)){
			String username = (String) session.getAttribute("myusername");
			alumni = alumniService.reMyAlumni(username);
            request.setAttribute("alumni", alumni);
            request.getRequestDispatcher("alumni/alumnimodify.jsp").forward(request, response);
		}else if("update".equals(doWhat)){
			String username = (String) session.getAttribute("myusername");
			alumni = alumniService.reMyAlumni(username);
            request.setAttribute("alumni", alumni);
            request.getRequestDispatcher("alumni/alumniupdate.jsp").forward(request, response);
		}else if("updatebyUsername".equals(doWhat)){
			try{
				BeanUtils.populate(alumni, alumniMap);
                alumniService.checkBlank(alumni);
                alumniService.updateByUsername(alumni);
                request.setAttribute("msg", "修改成功");
                request.getRequestDispatcher("alumni/alumniupdateresult.jsp").forward(request, response);
            }catch (Exception e){
            	request.setAttribute("msg", e.getMessage());
            	request.getRequestDispatcher("alumni/alumniupdateresult.jsp").forward(request, response);
            }
        }else if("delete".equals(doWhat)){
        	String username = (String) session.getAttribute("myusername");
			alumniService.delete(username);
            request.setAttribute("msg", "删除成功,请重新登录");
            request.getRequestDispatcher("alumni/alumnilogin.jsp").forward(request, response);
        }
	}

}

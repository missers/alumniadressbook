package team.aab.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import team.aab.bean.AdminBean;
import team.aab.bean.AlumniBean;
import team.aab.service.AdminService;
import team.aab.util.UserException;


public class AdminServlet extends HttpServlet {

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           this.doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to
     * post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        AdminService adminservice = new AdminService();
        String doWhat = (String) request.getParameter("doWhat");
        if ("login".equals(doWhat)) {
            AdminBean admin = new AdminBean();
            Map map = request.getParameterMap();
            try {
                BeanUtils.populate(admin, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                adminservice.login(admin);
                request.getRequestDispatcher("admin/adminmain.jsp").forward(request, response);
            } catch (UserException e) {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
            }
        }else if ("showall".equals(doWhat)) {
            List<AlumniBean> list = adminservice.showAll();
            request.setAttribute("aluList", list);
            request.getRequestDispatcher("admin/allalumni.jsp").forward(request, response);
        }else if("toUpdate".equals(doWhat)){
            String username = (String) request.getParameter("username");
            AlumniBean alumni = new AlumniBean();
            try {
                alumni = adminservice.getAluByUsername(username);
                request.setAttribute("alumni", alumni);
                request.getRequestDispatcher("admin/adminupdate.jsp").forward(request, response);
            } catch (UserException e) {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("admin/admindoresult.jsp").forward(request, response);
            }
        }else if("updatebyUsername".equals(doWhat)){
            AlumniBean alumni = new AlumniBean();
            Map map = request.getParameterMap();
            try{
                BeanUtils.populate(alumni, map);
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                adminservice.checkBlank(alumni);
                adminservice.updateByUsername(alumni);
                request.setAttribute("msg", "修改成功");
                request.getRequestDispatcher("admin/admindoresult.jsp").forward(request, response);
            }catch (Exception e){
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("admin/admindoresult.jsp").forward(request, response);
            }

        }else if("delete".equals(doWhat)){
            String username = (String) request.getParameter("username");
            try {
                adminservice.deleteByusername(username);
                request.setAttribute("msg", "删除成功");
                request.getRequestDispatcher("admin/admindoresult.jsp").forward(request, response);
            } catch (UserException e) {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("admin/admindoresult.jsp").forward(request, response);
            }
        }else if("add".equals(doWhat)){
            AlumniBean alumni = new AlumniBean();
            Map map = request.getParameterMap();
            try{
                BeanUtils.populate(alumni, map);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                adminservice.checkBlank(alumni);
                adminservice.addAlumni(alumni);
                request.setAttribute("msg", "添加成功");
                request.getRequestDispatcher("admin/addalumni.jsp").forward(request, response);
            }catch (Exception e){
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("admin/addalumni.jsp").forward(request, response);
            }
        }else if("select".equals(doWhat)){

            AlumniBean alumni = new AlumniBean();
            List<AlumniBean> list = adminservice.showAll();
            Map map = request.getParameterMap();
            try {
                BeanUtils.populate(alumni, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
               list = adminservice.showPart(alumni);
                request.setAttribute("aluList", list);
                request.getRequestDispatcher("admin/partalumni.jsp").forward(request, response);
            } catch (UserException e) {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("admin/adminselect.jsp").forward(request, response);
            }

        }

    }

}

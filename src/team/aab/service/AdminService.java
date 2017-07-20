package team.aab.service;

import org.apache.commons.beanutils.PropertyUtils;
import team.aab.bean.AdminBean;
import team.aab.bean.AlumniBean;
import team.aab.dao.AdminDao;
import team.aab.util.UserException;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * 
 * @author user
 *
 */
public class AdminService {

	/**
	 * 管理员登录
	 * @param admin
	 * @throws UserException
	 */
    public void login(AdminBean admin) throws UserException{
		AdminDao adminDao = new AdminDao();
    	adminDao.loginCheck(admin);	
    }

	/**
	 * 管理员申请显示全部校友信息
	 * @return
	 */
	public List<AlumniBean> showAll(){
		AdminDao adminDao = new AdminDao();
    	List<AlumniBean> list = adminDao.showAlumni();
    	return list;
	}
    public List<AlumniBean> showPart(AlumniBean alumn) throws UserException{
		AdminDao adminDao = new AdminDao();
		List<AlumniBean> aluList = adminDao.showPartAlu(alumn);
		return aluList;
	}

	/**
	 * 管理员通过username得到alumni
	 * @param username
	 * @return
	 */
	public AlumniBean getAluByUsername(String username) throws UserException {
		AdminDao adminDao = new AdminDao();
		  AlumniBean alumni =  adminDao.getAluByUsername(username);
		  return alumni;
	}

	/**
	 * 管理员通过username修改alumni的信息
	 * @param alumni
	 * @throws UserException
	 */
    public  void updateByUsername(AlumniBean alumni) throws UserException{
		AdminDao adminDao = new AdminDao();
		adminDao.updateByUsername(alumni);

	}

	/**
	 * 管理员通过username删除alumni的信息
	 * @param username
	 * @throws UserException
	 */
    public void deleteByusername(String username) throws UserException{
    	AdminDao adminDao = new AdminDao();
    	adminDao.deleteAlumni(username);
	}

	/**
	 * 管理员增加校友信息
	 * @param alumni
	 * @throws UserException
	 */
	public void addAlumni(AlumniBean alumni) throws Exception{
    	AdminDao adminDao = new AdminDao();
    	adminDao.checkReapt(alumni);
    	adminDao.addAlumni(alumni);
	}

	/**
	 * 检查部分信息是否为空
	 * @param alumni
	 * @throws UserException
	 */
	public void checkBlank(AlumniBean alumni) throws Exception{
		String username;
		String password;
		String name;
		String sex;
		String className;


		username = (String) PropertyUtils.getProperty(alumni, "username");
		password = (String) PropertyUtils.getProperty(alumni, "password");
		name = (String) PropertyUtils.getProperty(alumni, "name");
		sex = (String) PropertyUtils.getProperty(alumni, "sex");
		className = (String) PropertyUtils.getProperty(alumni, "className");
		if ("".equals(username) || "".equals(password) || "".equals(name) ||"".equals(className)) {
			throw new UserException("用户名、密码、姓名、班级存在为空项！以上项均不能为空！");
		}

	}

}

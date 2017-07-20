package team.aab.service;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import team.aab.bean.AlumniBean;
import team.aab.dao.AlumniDAO;
import team.aab.util.UserException;

public class AlumniService {
	public void login(AlumniBean alumni) throws UserException{
		AlumniDAO alumniDAO = new AlumniDAO();
		alumniDAO.checkAccount(alumni);
	}
	
	/**
	 * 校友注册业务
	 * @param alumni
	 * @throws UserException
	 */
	public void signUp(AlumniBean alumni) throws UserException{
		AlumniDAO alumniDAO = new AlumniDAO();
		alumniDAO.signUp(alumni);
	}
	
	/**
	 * 检查用户名是否存在业务
	 * @param alumni
	 * @throws UserException
	 */
	public void checkRepeat(AlumniBean alumni) throws UserException{
		AlumniDAO alumniDAO = new AlumniDAO();
		alumniDAO.signUp(alumni);
	}
	
	/**
	 * 检查规定非空数据是否为空业务
	 * @param alumni
	 * @throws Exception
	 */
	public void checkBlank(AlumniBean alumni) throws Exception{
		String username;
		String password;
		String name;
		String sex;
		String className;
		
		username = (String)PropertyUtils.getProperty(alumni, "username");
		password = (String)PropertyUtils.getProperty(alumni, "password");
		name = (String)PropertyUtils.getProperty(alumni, "name");
		className = (String)PropertyUtils.getProperty(alumni, "className");
		if("".equals(username) || "".equals(password) || "".equals(name) || "".equals(className)){
			throw new UserException("用户名、密码、姓名、所属班级存在为空项！以上项均不能为空！");
		}
	}
	
	/**
	 * 显示全部校友信息业务
	 * @return list
	 */
	public List<AlumniBean> showAll(){
		AlumniDAO alumniDAO = new AlumniDAO();
    	List<AlumniBean> list = alumniDAO.showAlumni();
    	return list;
	}
	
	/**
	 * 显示查询信息结果业务
	 * @param alumni
	 * @return list
	 */
	public List<AlumniBean> select(AlumniBean alumni){
		AlumniDAO alumniDAO = new AlumniDAO();
    	List<AlumniBean> list = alumniDAO.selectAlumni(alumni);
    	return list;
	}
	
	/**
	 * 返回本用户相关信息业务
	 * @param username
	 * @return alumni
	 */
	public AlumniBean reMyAlumni(String username){
		AlumniDAO alumniDAO = new AlumniDAO();
    	AlumniBean alumni = alumniDAO.reMyAlumni(username);
    	return alumni;
	}
	
	/**
	 * 修改自身信息业务
	 * @param alumni
	 * @throws UserException
	 */
    public void updateByUsername(AlumniBean alumni) throws UserException{
		AlumniDAO alumniDAO = new AlumniDAO();
		alumniDAO.updateByUsername(alumni);
	}
    
    /**
     * 删除自身信息业务
     * @param username
     */
    public void delete(String username){
		AlumniDAO alumniDAO = new AlumniDAO();
		alumniDAO.delete(username);
	}
}

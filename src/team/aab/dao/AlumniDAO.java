package team.aab.dao;

import team.aab.bean.AlumniBean;
import team.aab.util.Connect;
import team.aab.util.UserException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;


public class AlumniDAO {
	/**
	 * 检查登录输入数据与数据库数据是否匹配
	 * @param alumni
	 * @throws UserException
	 */
	public void checkAccount(AlumniBean alumni) throws UserException {
		Connect con = Connect.getInstance();
		
		String sql = "SELECT COUNT(1) FROM alumni WHERE username=? AND password=?";
		String username;
		String password;
		ArrayList<Object> param = new ArrayList<Object>();
		try {
			username = (String)PropertyUtils.getProperty(alumni, "username");
			password = (String)PropertyUtils.getProperty(alumni, "password");
			param.add(username);
			param.add(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int count = con.count(sql, param);
		
		if(count == 0){
			throw new UserException("用户名或密码错误！");
		}
	}
	
	/**
	 * 向数据库中插入注册数据
	 * @param alumni
	 * @throws UserException
	 */
	public void signUp(AlumniBean alumni) throws UserException {
		Connect con = Connect.getInstance();
		
		String sql = "INSERT INTO alumni(username, password, name, sex, birthday, className, tel, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		String username;
		String password;
		String name;
		String sex;
		String birthday;
		String className;
		String tel;
		String email;
		ArrayList<Object> param = new ArrayList<Object>();
		try {
			username = (String)PropertyUtils.getProperty(alumni, "username");
			password = (String)PropertyUtils.getProperty(alumni, "password");
			name = (String)PropertyUtils.getProperty(alumni, "name");
			sex = (String)PropertyUtils.getProperty(alumni, "sex");
			birthday = (String)PropertyUtils.getProperty(alumni, "birthday");
			className = (String)PropertyUtils.getProperty(alumni, "className");
			tel = (String)PropertyUtils.getProperty(alumni, "tel");
			email = (String)PropertyUtils.getProperty(alumni, "email");
			param.add(username);
			param.add(password);
			param.add(name);
			param.add(sex);
			param.add(birthday);
			param.add(className);
			param.add(tel);
			param.add(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.update(sql, param);
	}
	
	/**
	 * 检查数据库是否存在相同用户名
	 * @param alumni
	 * @throws UserException
	 */
	public void checkReapt(AlumniBean alumni) throws UserException {
		Connect con = Connect.getInstance();
		
		String sql = "SELECT COUNT(1) FROM alumnia WHERE username=?";
		String username;
		ArrayList<Object> param = new ArrayList<Object>();
		try {
			username = (String)PropertyUtils.getProperty(alumni, "username");
			param.add(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int count = con.count(sql, param);
		
		if(count != 0){
			throw new UserException("用户名重复，请重新输入！");
		}
	}
	
	/**
	 * 输出所有alumni表信息到List集合中
	 * @return aluList
	 */
	public List<AlumniBean> showAlumni(){
		Connect con = Connect.getInstance();
		String sql = "SELECT * FROM alumni";

		List<AlumniBean> aluList = (List)con.queryForArrObject(sql, null, AlumniBean.class);
		return aluList;
	}
	
	/**
	 * 输入班级或姓名对数据库进行查询
	 * @param alumni
	 * @return aluList
	 */
	public List<AlumniBean> selectAlumni(AlumniBean alumni){
		Connect con = Connect.getInstance();
		
		String name;
		String className;
		ArrayList<Object> param = new ArrayList<Object>();
		List<AlumniBean> aluList = new ArrayList<AlumniBean>();
		try {
			name = (String)PropertyUtils.getProperty(alumni, "name");
			className = (String)PropertyUtils.getProperty(alumni, "className");
			if("".equals(name)){
				param.add(className);
				String sql = "SELECT * FROM alumni WHERE className=?";
				aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
			}else if("".equals(className)){
				param.add(name);
				String sql = "SELECT * FROM alumni WHERE name=?";
				aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
			}else{
				param.add(name);
				param.add(className);
				String sql = "SELECT * FROM alumni WHERE name=? AND className=?";
				aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aluList;
	}
	
	/**
	 * 通过用户名查询数据库返回自身信息
	 * @param username
	 * @return alumni
	 */
	public AlumniBean reMyAlumni(String username){
		Connect con = Connect.getInstance();
		
		ArrayList<Object> param = new ArrayList<Object>();
		List<AlumniBean> aluList = new ArrayList<AlumniBean>();
		param.add(username);
		String sql = "SELECT * FROM alumni WHERE username=?";
		aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
		AlumniBean alumni = aluList.get(0);

		return alumni;
	}
	
	/**
	 * 对数据库中校友用户自身信息修改
	 * @param alumni
	 * @throws UserException
	 */
	public void updateByUsername(AlumniBean alumni) throws UserException{
		Connect con = Connect.getInstance();

		String  username, password, name, sex, birthday, className, tel, email;
		ArrayList<Object> param = new ArrayList<Object>();
		String sql = "UPDATE  alumni SET password=?, name=?, sex =?," +
				"birthday=?, className=?, tel=?, email=? where username=?";
		try {
			username = (String) PropertyUtils.getProperty(alumni, "username");
			password = (String) PropertyUtils.getProperty(alumni, "password");
			name = (String) PropertyUtils.getProperty(alumni, "name");
			sex = (String) PropertyUtils.getProperty(alumni, "sex");
			birthday = (String) PropertyUtils.getProperty(alumni, "birthday");
			className = (String) PropertyUtils.getProperty(alumni, "className");
			tel = (String) PropertyUtils.getProperty(alumni, "tel");
			email = (String) PropertyUtils.getProperty(alumni, "email");

			param.add(password);
			param.add(name);
			param.add(sex);
			param.add(birthday);
			param.add(className);
			param.add(tel);
			param.add(email);
			param.add(username);
			
			con.update(sql, param);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 对数据库中校友用户自身信息删除
	 * @param username
	 */
	public void delete(String username){
		Connect con = Connect.getInstance();

		ArrayList<Object> param = new ArrayList<Object>();
		String sql = "DELETE FROM alumni WHERE username=?";
	
		param.add(username);
		con.update(sql, param);

	}
}

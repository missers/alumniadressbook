package team.aab.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import team.aab.bean.AdminBean;
import team.aab.bean.AlumniBean;
import team.aab.util.UserException;
import team.aab.util.Connect;

public class AdminDao {
	/**
	 * 管理员登录检测
	 * @param admin
	 * @throws UserException
	 */
	public void loginCheck(AdminBean admin) throws UserException {
		Connect con = Connect.getInstance();
		String sql = "select COUNT(1) from admin where username=? and password=?";

		ArrayList<Object> param = new ArrayList<Object>();
		String username = admin.getUsername();
		String password = admin.getPassword();

		param.add(username);
		param.add(password);

		int count = con.count(sql, param);
		if (count == 0) {
			throw new UserException("用户名或密码错误！");
		}
	}

	/**
	 * 查询全部校友信息
	 * @return
	 */
	public List<AlumniBean> showAlumni(){
		Connect con = Connect.getInstance();
		String sql = "select * from alumni";

		List<AlumniBean> aluList = (List)con.queryForArrObject(sql, null, AlumniBean.class);
		return aluList;
	}
    public List<AlumniBean> showPartAlu (AlumniBean alumni)throws UserException{
	    String username = alumni.getUsername();
	    String name = alumni.getName();
        List<AlumniBean> aluList = new ArrayList<AlumniBean>();
	    AdminDao adminDao = new AdminDao();

	    if("".equals(username) && "".equals(name)){
	        throw new UserException("用户名和姓名至少填写一个");
        }else if("".equals(username) && (!"".equals(name))){
            aluList = adminDao.getAlusByName(name);
        }else if((!"".equals(username)) && "".equals(name)){
            aluList = adminDao.getAlusByUsername(username);
        }else if((!"".equals(username)) && (!"".equals(name))){
            aluList = adminDao.getAlusByNameAndusername(username, name);
        }
        return aluList;
    }
    public  List<AlumniBean> getAlusByNameAndusername (String username, String name)throws UserException{
        Connect con = Connect.getInstance();
        chackAlumniByUsernameAndUsername(con, username, name);
        String sql = "select * from alumni where username=? And name=?";
        ArrayList<Object> param = new ArrayList<Object>();
        param.add(username);
        param.add(name);
        List<AlumniBean> aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
        return aluList;
    }
    /**
     * 根据校友姓名查找信息,返回一个集合
     * @param username
     * @return
     * @throws UserException
     */
    public  List<AlumniBean> getAlusByName (String name)throws UserException{
        Connect con = Connect.getInstance();
        chackAlumniByName(con, name);
        String sql = "select * from alumni where name=?";
        ArrayList<Object> param = new ArrayList<Object>();
        param.add(name);
        List<AlumniBean> aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
        return aluList;
    }
    /**
     * 根据校友用户名查找信息,返回一个集合
     * @param username
     * @return
     * @throws UserException
     */
    public  List<AlumniBean> getAlusByUsername (String username)throws UserException{
        Connect con = Connect.getInstance();
        chackAlumniByUsername(con, username);
        String sql = "select * from alumni where username=?";
        ArrayList<Object> param = new ArrayList<Object>();
        param.add(username);
        List<AlumniBean> aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
        return aluList;
    }
	/**
	 * 根据校友用户名查找信息,返回一个对象
	 * @param username
	 * @return
	 */
	public  AlumniBean getAluByUsername (String username)throws UserException{
		Connect con = Connect.getInstance();
		chackAlumniByUsername(con, username);
		String sql = "select * from alumni where username=?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(username);
		List<AlumniBean> aluList = (List)con.queryForArrObject(sql, param, AlumniBean.class);
		AlumniBean alu = aluList.get(0);
		return alu;
	}
    public static void chackAlumniByUsernameAndUsername(Connect con, String username, String name) throws UserException{
        String sql = "select COUNT(1) from alumni where username=? And name=?";

        ArrayList<Object> param = new ArrayList<Object>();

        param.add(username);
        param.add(name);
        int count = con.count(sql, param);
        if (count == 0) {
            throw new UserException("用户名为："+username+"姓名为："+name+"的校友找不到");
        }
    }

	/**
	 * 通过校友的username判断是否存在，不存在时抛异常
	 * @param con
	 * @param username
	 * @throws UserException
	 */
    public static void chackAlumniByUsername(Connect con, String username) throws UserException{
		String sql = "select COUNT(1) from alumni where username=? ";

		ArrayList<Object> param = new ArrayList<Object>();

		param.add(username);

		int count = con.count(sql, param);
		if (count == 0) {
			throw new UserException("用户名为："+username+"的校友找不到");
		}
	}

    /**
     * 通过校友的name判断是否存在，不存在时抛异常
     * @param con
     * @param username
     * @throws UserException
     */
    public static void chackAlumniByName(Connect con, String name) throws UserException{
        String sql = "select COUNT(1) from alumni where name=? ";

        ArrayList<Object> param = new ArrayList<Object>();

        param.add(name);

        int count = con.count(sql, param);
        if (count == 0) {
            throw new UserException("姓名为："+name+"的校友找不到");
        }
    }

	/**
	 * 根据校友的username删除其信息
	 * @param username
	 * @throws UserException
	 */
	public void deleteAlumni(String username) throws UserException{
		Connect con = Connect.getInstance();
		chackAlumniByUsername(con,username);
    	String sql = "delete from alumni where username = ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(username);
		con.update(sql, param);
	}
	/**
	 * 根据校友的username修改信息
	 * @param alumni
	 * @throws UserException
	 */
	public void updateByUsername(AlumniBean alumni) throws UserException{
		Connect con = Connect.getInstance();

		String  username, password, name, sex, birthday, className, tel, email;
		ArrayList<Object> param = new ArrayList<Object>();
		String sql = "Update  alumni set password=?, name=?, sex =?," +
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

			chackAlumniByUsername(con,username);//检查校友是否存在
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
	 * 管理员添加校友信息
	 * @param alumni
	 */
	public void addAlumni(AlumniBean alumni) throws Exception{
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
        username = (String) PropertyUtils.getProperty(alumni, "username");
        password = (String) PropertyUtils.getProperty(alumni, "password");
        name = (String) PropertyUtils.getProperty(alumni, "name");
        sex = (String) PropertyUtils.getProperty(alumni, "sex");
        birthday = (String) PropertyUtils.getProperty(alumni, "birthday");
        className = (String) PropertyUtils.getProperty(alumni, "className");
        tel = (String) PropertyUtils.getProperty(alumni, "tel");
        email = (String) PropertyUtils.getProperty(alumni, "email");
        param.add(username);
        param.add(password);
        param.add(name);
        param.add(sex);
        param.add(birthday);
        param.add(className);
        param.add(tel);
        param.add(email);


        con.update(sql, param);
	}

	/**
	 * 检查用户是否存在，存在时抛异常
	 * @param alumni
	 * @throws UserException
	 */
	public void checkReapt(AlumniBean alumni) throws UserException {
		Connect con = Connect.getInstance();

		String sql = "SELECT COUNT(1) FROM alumni WHERE username=?";
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

}

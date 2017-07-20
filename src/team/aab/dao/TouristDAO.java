package team.aab.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import team.aab.bean.AlumniBean;
import team.aab.util.Connect;

public class TouristDAO {
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
}

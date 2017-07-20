package team.aab.service;

import java.util.List;

import team.aab.bean.AlumniBean;
import team.aab.dao.TouristDAO;

public class TouristService {
	/**
	 * 显示查询信息结果业务
	 * @param alumni
	 * @return list
	 */
	public List<AlumniBean> select(AlumniBean alumni){
		TouristDAO touristDAO = new TouristDAO();
    	List<AlumniBean> list = touristDAO.selectAlumni(alumni);
    	return list;
	}
}

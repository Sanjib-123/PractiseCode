package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
@Profile({"dev","test"})
public class MysqlEmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESGS="SELECT ENO,ENAME,DESG,SALARY,DEPTNO FROM EMP WHERE DESG IN(?,?,?)ORDER BY DESG";
	@Autowired
	private DataSource ds;
	
	public MysqlEmployeeDAOImpl() {
		System.out.println("MysqlEmployeeDAOImpl:0-param constructor");
	}
	
	public List<Employee> getEmployeesByDesgs(String desg1,String desg2,String desg3)
            throws Exception{
		List<Employee>list = null;
		//get polled jdbc con object
		try(Connection con = ds.getConnection();
				//create PreparedStatement obj
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS)
				){
			//set values to query params
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			//execute the query
			try(ResultSet rs = ps.executeQuery()){
				//copy the records of resultset obj to list<Employee>obj
				list = new ArrayList();
				while(rs.next()) {
					//copy each record of rs to employee obj
					Employee emp = new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					//add Employee object to List cOLLECTION
					list.add(emp);
				}//while
			}//try
			
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}

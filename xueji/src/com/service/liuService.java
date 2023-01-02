package com.service;

import java.sql.ResultSet;

import com.dao.DB;
import com.orm.Tzhuanye;

public class liuService
{
	/**
	 * 根据ID查询专业信息
	 * @param id
	 * @return
	 */
	public static String getZhuanyeName(int id)
	{
		String zhuanye_name="";
		
		String sql="select * from t_zhuanye where id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			zhuanye_name=rs.getString("name");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return zhuanye_name;
	}
	
	/**
	 * 根据ID查询班级信息
	 * @param id
	 * @return
	 */
	public static String getBanjiName(int id)
	{
		String name="";
		
		String sql="select * from t_banji where id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			name=rs.getString("name");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return name;
	}
	
	/**
	 * 根据ID查询学生信息
	 * @param id
	 * @return
	 */
	public static String getStuXuehao(int id)
	{
		String xuehao="";
		
		String sql="select * from t_stu where id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			xuehao=rs.getString("xuehao");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return xuehao;
	}
	public static int getApplyStu_id(int id)
	{
		int stu_id=0;
		
		String sql="select * from t_apply where id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			stu_id=rs.getInt("stu_id");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return stu_id;
	}
	public static int getApplyBanji_id(int id)
	{
		int banji_id=0;
		
		String sql="select * from t_apply where id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			banji_id=rs.getInt("banji_id2");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return banji_id;
	}
	/**
	 * 根据学号查询学生信息
	 * @param xuehao
	 * @return
	 */
	public static boolean jianchaxuhao(String xuehao)
	{
		boolean shichongfu=false;
		
		String sql="select * from t_stu where xuehao=?";
		Object[] params={xuehao};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			if(rs.next()==true)
			{
				shichongfu=true;
			}
			else
			{
				shichongfu=false;
			}
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return shichongfu;
	}
	
	/**
	 * 根据ID查询课程信息
	 * @param id
	 * @return
	 */
	public static String getKechengName(int id)
	{
		String name="";
		
		String sql="select * from t_kecheng where id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			name=rs.getString("name");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return name;
	}

}

package com.service;

import java.sql.ResultSet;

import com.dao.DB;
import com.orm.Tzhuanye;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
	public static boolean jianchengji(int sid,int kid)
	{
		boolean shichongfu=false;
		
		String sql="select * from t_chengji where stu_id=? and kecheng_id=? ";
		Object[] params={sid,kid};
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

public static String getKechengXuenian(int id)
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
		name=rs.getString("xuenian");
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return name;
}
public static int getKechengXuefen(int id)
{
	int name=0;
	
	String sql="select * from t_kecheng where id="+id;
	Object[] params={};
	DB mydb=new DB();
	try
	{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		rs.next();
		name=rs.getInt("xuefen");
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return name;
}
public static int getTid(int id)
{
	int name=0;
	
	String sql="select * from t_kecheng where id="+id;
	Object[] params={};
	DB mydb=new DB();
	try
	{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		rs.next();
		name=rs.getInt("tid");
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return name;
}
public static String getType(int id)
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
		name=rs.getString("type");
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return name;
}
public static String getavg(int id)
{
	String name="0";
	int a=0,kid=0;
	int b=0,c=0;
	double d=0;
	String sql="select * from t_chengji where chengji>=60 and stu_id="+id;
	Object[] params={};
	DB mydb=new DB();
	try
	{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		while(rs.next()) {
		a=rs.getInt("chengji");
		kid=rs.getInt("kecheng_id");
		b=getKechengXuefen(kid);
		c=c+b;
		d=d+(a-50)*0.1*b;
		}
		d=d/c;
		name=format1(d);
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
 * 往t_stu插入绩点
 * @param value
 * @return
 */
public static String putgrade(int id)
{   double grade=0;
	String name="";
	name=getavg(id);
	grade=Double.parseDouble(name);
	String sql="update t_stu set avggrade=? where id="+id;
	Object[] params={grade};
	DB mydb=new DB();
	mydb.doPstm(sql, params);
	mydb.closed();
	return name;
}
public static String format1(double value) {

	 BigDecimal bd = new BigDecimal(value);
	 bd = bd.setScale(3, RoundingMode.HALF_UP);
	 return bd.toString();
	}
/*根据学生id查询课程id*/

public static int getA(int id)
{
	int n=0,i=0;
	
	String sql="select * from t_chengji where stu_id="+id;
	Object[] params={};
	DB mydb=new DB();
	try
	{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		while(rs.next()) {
		  if(getTid(rs.getInt("kecheng_id"))==1&&rs.getInt("chengji")>=60) {
		n=n+getKechengXuefen(rs.getInt("kecheng_id"));
		}
		  i++;
		}
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return n;
}
public static int getB(int id)
{
	int n=0,i=0;
	
	String sql="select * from t_chengji where stu_id="+id;
	Object[] params={};
	DB mydb=new DB();
	try
	{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		while(rs.next()) {
		  if(getTid(rs.getInt("kecheng_id"))==2&&rs.getInt("chengji")>=60) {
		n=n+getKechengXuefen(rs.getInt("kecheng_id"));
		}
		  i++;
		}
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return n;
}
public static int getC(int id)
{
	int n=0,i=0;
	
	String sql="select * from t_chengji where stu_id="+id;
	Object[] params={};
	DB mydb=new DB();
	try
	{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		while(rs.next()) {
		  if(getTid(rs.getInt("kecheng_id"))==3&&rs.getInt("chengji")>=60) {
		n=n+getKechengXuefen(rs.getInt("kecheng_id"));
		}
		  i++;
		}
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return n;
}
public static int getD(int id)
{
	int n=0,i=0;
	
	String sql="select * from t_chengji where stu_id="+id;
	Object[] params={};
	DB mydb=new DB();
	try
	{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		while(rs.next()) {
		  if(getTid(rs.getInt("kecheng_id"))==4&&rs.getInt("chengji")>=60) {
		n=n+getKechengXuefen(rs.getInt("kecheng_id"));
		}
		  i++;
		}
		rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	mydb.closed();
	return n;
}
}

package com.action;

import java.io.IOException;
/**
 * 成绩模块的控制层
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tchengji;
import com.service.liuService;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;



public class chengji_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("chengjiMana"))
		{
			chengjiMana(req, res);
		}
		if(type.endsWith("chengjiAdd"))
		{
			chengjiAdd(req, res);
		}
		if(type.endsWith("chengjiDel"))
		{
			chengjiDel(req, res);
		}
	}
	
	
	
	public void chengjiAdd(HttpServletRequest req,HttpServletResponse res)
	{
		int stu_id=Integer.parseInt(req.getParameter("stu_id"));
		int kecheng_id=Integer.parseInt(req.getParameter("kecheng_id"));
		int chengji=Integer.parseInt(req.getParameter("chengji"));
		String grade="0";
		double one = (chengji-50)/10.0;
		if(chengji>=60) {
		grade=format1(one);}
		String del="no";
		if(liuService.jianchengji(stu_id,kecheng_id)==true)
		{
			req.setAttribute("message", "课程重复。请重新输入");
			req.setAttribute("path", "admin/chengji/chengjiAdd.jsp");
			String targetURL = "/common/success.jsp";
			dispatch(targetURL, req, res);
		}
		else {
		String sql="insert into t_chengji values(default,?,?,?,?,?)";
		Object[] params={stu_id,kecheng_id,chengji,grade,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chengji?type=chengjiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}}
	
	public void chengjiDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_chengji set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chengji?type=chengjiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void chengjiMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chengjiList=new ArrayList();
		String sql="select * from t_chengji where del='no' order by chengji desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchengji chengji=new Tchengji();
				chengji.setId(rs.getInt("id"));
				chengji.setStu_id(rs.getInt("stu_id"));
				chengji.setKecheng_id(rs.getInt("kecheng_id"));
				chengji.setChengji(rs.getInt("chengji"));
				String grade="0";
				
				double one = (rs.getInt("chengji")-50)/10.0;
				if(rs.getInt("chengji")>=60) {
			    grade=format1(one);}
				chengji.setGrade(grade);
				chengji.setXuenian(liuService.getKechengXuenian(rs.getInt("kecheng_id")));
				chengji.setKe_xuefen(liuService.getKechengXuefen(rs.getInt("kecheng_id")));
				chengji.setStu_xuehao(liuService.getStuXuehao(rs.getInt("stu_id")));
				chengji.setKecheng_name(liuService.getKechengName(rs.getInt("kecheng_id")));
				chengji.setType(liuService.getType(rs.getInt("kecheng_id")));
				chengjiList.add(chengji);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chengjiList", chengjiList);
		req.getRequestDispatcher("admin/chengji/chengjiMana.jsp").forward(req, res);
	}
	public static String format1(double value) {

		 BigDecimal bd = new BigDecimal(value);
		 bd = bd.setScale(1, RoundingMode.HALF_UP);
		 return bd.toString();
		}


	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}

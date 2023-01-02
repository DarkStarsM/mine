package com.action;

import java.io.IOException;
/**
 * 转专业的控制层
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
import com.orm.Tbanji;
import com.orm.Tstu;
import com.orm.Tapply;
import com.service.liuService;

public class apply_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("applyMana"))
		{
			applyMana(req, res);
		}
		 
			
		if(type.endsWith("applySec"))
		{
			applySec(req, res);
		}
		if(type.endsWith("applyDel"))
		{
			applyDel(req, res);
		}
	}


	
	
	public void applySec(HttpServletRequest req,HttpServletResponse res)
	{   
		int id=Integer.parseInt(req.getParameter("id"));
		int banji_id2=liuService.getApplyBanji_id(id);
		int stu_id=liuService.getApplyStu_id(id);
		String sql="update t_stu set banji_id=? where id="+stu_id;
		Object[] params={banji_id2};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		String sql2="update t_apply set del='yes' where id="+id;
		Object[] params2={};
		DB mydb2=new DB();
		mydb2.doPstm(sql2, params2);
		mydb2.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "apply?type=applyMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void applyDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_apply set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "apply?type=applyMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void applyMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List applyList=new ArrayList();
		String sql="select * from t_apply where del='no' ";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tapply apply=new Tapply();
				apply.setId(rs.getInt("id"));
				apply.setStu_id(rs.getInt("stu_id"));
				apply.setBanji_id(rs.getInt("banji_id"));
				apply.setBanji_name2(liuService.getBanjiName(rs.getInt("banji_id2")));
				apply.setBanji_id2(rs.getInt("banji_id2"));
				apply.setStu_xuehao(liuService.getStuXuehao(rs.getInt("stu_id")));
				apply.setBanji_name(liuService.getBanjiName(rs.getInt("banji_id")));
				applyList.add(apply);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("applyList",applyList);
		req.getRequestDispatcher("admin/apply/applyMana.jsp").forward(req, res);
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

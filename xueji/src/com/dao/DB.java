package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 涓庢暟鎹簱鐨勮繛鎺ュ眰
 * @author Administrator
 *
 */
public class DB
{
	private Connection con;

	private PreparedStatement pstm;

	private String user = "root";//鏁版嵁搴撶殑杩炴帴鍚� 

	private String password = "mb20020428";//鏁版嵁搴撶殑杩炴帴瀵嗙爜锛岄渶瑕佹敼鎴愪綘鑷繁鐨�

//	private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String className = "com.mysql.jdbc.Driver";

//	private String url = "jdbc:sqlserver://localhost:1433;databaseName=db_xueji";
	
	private String url = "jdbc:mysql://localhost:3306/db_xueji?useUnicode=true&characterEncoding=utf-8";
	
	/*
	 * private String url =
	 * "jdbc:mysql://localhost:3306/db_xueji?useUnicode=true&amp;amp;amp;amp;amp;amp;characterEncoding=utf-8";
	 */

	public DB()
	{
		try
		{
			Class.forName(className);
		} catch (ClassNotFoundException e)
		{
			System.out.println("鍔犺浇鏁版嵁搴撻┍鍔ㄥけ璐ワ紒");
			e.printStackTrace();
		}
	}

	/** 鍒涘缓鏁版嵁搴撹繛鎺� */
	public Connection getCon()
	{
		try
		{
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e)
		{
			System.out.println("鍒涘缓鏁版嵁搴撹繛鎺ュけ璐ワ紒");
			con = null;
			e.printStackTrace();
		}
		return con;
	}

	public void doPstm(String sql, Object[] params)
	{
		if (sql != null && !sql.equals(""))
		{
			if (params == null)
				params = new Object[0];

			getCon();
			if (con != null)
			{
				try
				{
					System.out.println(sql);
					pstm = con.prepareStatement(sql,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					for (int i = 0; i < params.length; i++)
					{
						pstm.setObject(i + 1, params[i]);
					}
					pstm.execute();
				} catch (SQLException e)
				{
					System.out.println("doPstm()鏂规硶鍑洪敊锛�");
					e.printStackTrace();
				}
			}
		}
	}

	public ResultSet getRs() throws SQLException
	{
		return pstm.getResultSet();
	}

	public int getCount() throws SQLException
	{
		return pstm.getUpdateCount();
	}

	public void closed()
	{
		try
		{
			if (pstm != null)
				pstm.close();
		} catch (SQLException e)
		{
			System.out.println("鍏抽棴pstm瀵硅薄澶辫触锛�");
			e.printStackTrace();
		}
		try
		{
			if (con != null)
			{
				con.close();
			}
		} catch (SQLException e)
		{
			System.out.println("鍏抽棴con瀵硅薄澶辫触锛�");
			e.printStackTrace();
		}
	}
}

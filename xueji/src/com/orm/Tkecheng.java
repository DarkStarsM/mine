package com.orm;
/**
 * 课程的实体类
 * @author Administrator
 *
 */
public class Tkecheng
{
	private int id;
	private String name;
	private String jieshao;
	private String del;
	private String xuenian;
	
	private int xuefen;
	public String getXuenian()
	{
		return xuenian;
	}
	public void setXuenian(String xuenian)
	{
		this.xuenian = xuenian;
	}
	public String getDel()
	{
		return del;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getXuefen()
	{
		return xuefen;
	}
	public void setXuefen(int xuefen)
	{
		this.xuefen = xuefen;
	}
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

}

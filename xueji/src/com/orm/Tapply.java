
package com.orm;
/**
 * 转专业的实体类
 * @author Administrator
 *
 */
public class Tapply
{
	private int id;
	private int stu_id;
	private int banji_id;
    private int banji_id2;
	private String banji_name;
	private String stu_xuehao;
	private String banji_name2;
	
	public int getBanji_id2()
	{
		return banji_id2;
	}
	public void setBanji_id2(int banji_id2)
	{
		this.banji_id2 = banji_id2;
	}
	public int getBanji_id()
	{
		return banji_id;
	}
	public void setBanji_id(int banji_id)
	{
		this.banji_id = banji_id;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getStu_id()
	{
		return stu_id;
	}
	public void setStu_id(int stu_id)
	{
		this.stu_id = stu_id;
	}
	public String getBanji_name()
	{
		return banji_name;
	}
	public void setBanji_name(String banji_name)
	{
		this.banji_name = banji_name;
	}
	
	public String getBanji_name2()
	{
		return banji_name2;
	}
	public void setBanji_name2(String banji_name2)
	{
		this.banji_name2 = banji_name2;
	}

	public String getStu_xuehao()
	{
		return stu_xuehao;
	}
	public void setStu_xuehao(String stu_xuehao)
	{
		this.stu_xuehao = stu_xuehao;
	}
	
}

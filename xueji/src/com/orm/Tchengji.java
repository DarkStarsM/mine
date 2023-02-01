
package com.orm;
/**
 * 成绩的实体类
 * @author Administrator
 *
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Tchengji
{
	private int id;
	private int stu_id;
	private int ke_xuefen;
	private int kecheng_id;
    private int chengji;
    private String grade;
	private String ke_xuenian;
	private String stu_xuehao;
	private String type;
	private String kecheng_name;
	
	public int getChengji()
	{
		return chengji;
	}
	public void setChengji(int chengji)
	{
		this.chengji = chengji;
	}
	public int getKe_xuefen()
	{
		return ke_xuefen;
	}
	public void setKe_xuefen(int ke_xuefen)
	{
		this.ke_xuefen = ke_xuefen;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getGrade()
	{
		return grade;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
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
	public String getKe_xuenian()
	{
		return ke_xuenian;
	}
	public void setXuenian(String ke_xuenian)
	{
		this.ke_xuenian = ke_xuenian;
	}
	
	public String getKecheng_name()
	{
		return kecheng_name;
	}
	public void setKecheng_name(String kecheng_name)
	{
		this.kecheng_name = kecheng_name;
	}
	public int getKecheng_id()
	{
		return kecheng_id;
	}
	public void setKecheng_id(int kecheng_id)
	{
		this.kecheng_id = kecheng_id;
	}
	public String getStu_xuehao()
	{
		return stu_xuehao;
	}
	public void setStu_xuehao(String stu_xuehao)
	{
		this.stu_xuehao = stu_xuehao;
	}
	public static String format1(double value) {

		 BigDecimal bd = new BigDecimal(value);
		 bd = bd.setScale(2, RoundingMode.HALF_UP);
		 return bd.toString();
		}
}

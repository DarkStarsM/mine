
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
        
        <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        <script language="javascript">
           var i=0;
           function banjiAll()
           {
               if(i==0)
               {
                   document.getElementById("indicator").style.display="block";
                   loginService.banjiAll(callback);
                   i=1;
               }
               
           }
           function callback(data)
           {
               document.getElementById("indicator").style.display="none";
               DWRUtil.addOptions("banji_id",data,"id","name");
           }
           
           function check()
           {
               if(document.formAdd.banji_id.value==0)
               { 
                   alert("请选择班级");
                   return false;
               }
               return true;
           }
           function p()
           {
              window.print();
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
	        
			<form action="<%=path %>/stu?type=stuEdit" name="formAdd" method="post">
			<table width="60%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
				     <td height="14" colspan="100" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="30%">课程类型</td>
					<td width="30%">要求学分</td>
					<td width="30%">已修学分</td>
		        </tr>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						通识课程
					</td>
					<td bgcolor="#FFFFFF" align="center">
						5
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <c:if test="${requestScope.stu.a>='5' }">
                        <font>${requestScope.stu.a}</font>
                        </c:if>
                        <c:if test="${requestScope.stu.a<'5' }">
                        <font color="red">${requestScope.stu.a}</font>
                        </c:if>
						
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						大类基础课
					</td>
					<td bgcolor="#FFFFFF" align="center">
						6
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <c:if test="${requestScope.stu.b>='6' }">
                        <font>${requestScope.stu.b}</font>
                        </c:if>
                        <c:if test="${requestScope.stu.b<'6' }">
                        <font color="red">${requestScope.stu.b}</font>
                        </c:if>
						
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						专业课程
					</td>
					<td bgcolor="#FFFFFF" align="center">
						6
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <c:if test="${requestScope.stu.c>='6' }">
                        <font>${requestScope.stu.c}</font>
                        </c:if>
                        <c:if test="${requestScope.stu.c<'6' }">
                        <font color="red">${requestScope.stu.c}</font>
                        </c:if>
						
					</td>
				</tr>
			    <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						实践课程
					</td>
					<td bgcolor="#FFFFFF" align="center">
						5
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <c:if test="${requestScope.stu.d>='6' }">
                        <font>${requestScope.stu.d}</font>
                        </c:if>
                        <c:if test="${requestScope.stu.d<'6' }">
                        <font color="red">${requestScope.stu.d}</font>
                        </c:if>
						
					</td>
				</tr>
			</form>
   </body>
</html>

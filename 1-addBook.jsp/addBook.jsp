<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ok.jsp">
<table width="417" border="0">
  <tr>
    <td width="411" height="67" ><h1>增加图书</h1></td>
  </tr>
</table>


<table width="418" height="417" border="1">

  <tr>
    <td width="76">图书编号</td>
    <td width="326"><input type="text"width="300"/>
</td>
  </tr>
  <tr>
    <td>书名</td>
    <td><input type="text"  width="300"/>
</td>
  </tr>
  <tr>
    <td height="210">内容简介</td>
    <td><input type="text"height="200"  width="300" />
</td>
  </tr>
  <tr>
    <td>类别</td>
    <td><select name="select" id="select_k1" class="xla_k"> 
	   <option value="计算机">计算机</option>
	   <option value="软件">软件</option>
	   <option value="嵌入式">嵌入式</option>  
	     </select></td>
  </tr>
  <tr>
    <td>检索关键字</td>
    <td>
	<input name="save" id="save" type="checkbox" onClick="save_ck(this);" >java
	<input name="save" id="save" type="checkbox" onClick="save_ck(this);" >C++
    <input name="save" id="save" type="checkbox" onClick="save_ck(this);" >C
	<input name="save" id="save" type="checkbox" onClick="save_ck(this);" >C#
	</td>
  </tr>
  <tr>
    <td height="27">&nbsp;</td>
    <td>
	<button type='submit'>确定</button>
	<button type='button'>取消</button>
	</td>
  </tr>
</table>
</form>
</body>
</html>
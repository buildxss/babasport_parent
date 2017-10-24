<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>babasport-list</title>
</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 品牌管理 - 列表</div>
		<form class="ropt">
			<input class="add" type="button" value="添加"
				onclick="javascript:window.location.href='add.jsp'" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="body-box">
		<form action="list.do" method="post" style="padding-top: 5px;">
			品牌名称: <input type="text" name="name" value="${name}" /> <select
				name="isDisplay">
				<option value="1"
					<c:if test="${isDisplay==1 }">selected='selected'</c:if>>是</option>
				<option value="0"
					<c:if test="${isDisplay==0 }">selected='selected'</c:if>>否</option>
			</select> <input type="submit" class="query" value="查询" />
		</form>
		<table cellspacing="1" cellpadding="0" border="0" width="100%"
			class="pn-ltable">
			<thead class="pn-lthead">
				<tr>
					<th width="20"><input type="checkbox"
						onclick="checkBox('ids',this.checked)" /></th>
					<th>品牌ID</th>
					<th>品牌名称</th>
					<th>品牌图片</th>
					<th>品牌描述</th>
					<th>排序</th>
					<th>是否可用</th>
					<th>操作选项</th>
				</tr>
			</thead>
			<tbody class="pn-ltbody">
				<c:forEach items="${brandPage.result }" var="brand">
					<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'"
						onmouseover="this.bgColor='#eeeeee'">
						<td><input type="checkbox" value="8" name="ids" /></td>
						<td align="center">${brand.id }</td>
						<td align="center">${brand.name }</td>
						<td align="center"><img width="40" height="40"
							src="${brand.imgUrl }" /></td>
						<td align="center">${brand.description }</td>
						<td align="center">${brand.sort }</td>
						<td align="center"><c:if test="${brand.isDisplay == 1 }">是</c:if>
							<c:if test="${brand.isDisplay == 0 }">否</c:if></td>
						<td align="center"><a class="pn-opt" href="edit.do?brandId=${brand.id }">修改</a> | <a
							class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}"
							href="#">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page pb15">
			<span class="r inb_a page_b"> <font size="2"><a
					href="list.do?pageNum=1">首页</a></font> <font size="2"><a
					href="list.do?pageNum=${brandPage.pageNum - 1 }">上一页</a></font>
					<c:forEach begin="1" end="${brandPage.pages}" var="pageNum">
						<c:if test="${brandPage.pageNum > 5 && brandPage.pageNum == pageNum}">
							<c:forEach begin="${brandPage.pageNum - 4 }" end="${brandPage.pages }" var="preNum">
								<c:if test="${preNum==brandPage.pageNum }"><strong>${preNum }</strong></c:if>
								<c:if test="${preNum!=brandPage.pageNum }"><strong><a href="list.do?pageNum=${preNum }">${preNum }</a></strong></c:if>
							</c:forEach>							
						</c:if>
						<c:if test="${brandPage.pageNum <= 5 }">
							<c:if test="${pageNum==brandPage.pageNum }"><strong>${pageNum }</strong></c:if>
							<c:if test="${pageNum!=brandPage.pageNum }"><strong><a href="list.do?pageNum=${pageNum }">${pageNum }</a></strong></c:if>
						</c:if>	
					</c:forEach>
					 <font
				size="2"><a href="list.do?pageNum=${brandPage.pageNum + 1 }">下一页</a></font>
				<font size="2"><a href="list.do?pageNum=${brandPage.pages }">尾页</a></font>
				共<var>${brandPage.pages }</var>页 到第<input type="text" size="3"
				id="PAGENO" />页 <input type="button"
				onclick="javascript:window.location.href='list.do?pageNum='+$('#PAGENO').val()"
				value="确定" class="hand btn60x20" id="skip" />
			</span>
		</div>
		<div style="margin-top: 15px;">
			<input class="del-button" type="button" value="删除"
				onclick="optDelete();" />
		</div>
	</div>
</body>
</html>
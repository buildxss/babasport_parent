<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-edit</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='v_list.shtml';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
    <form id="jvForm" action="doEdit.do" method="post">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						品牌名称:</td><td width="80%" class="pn-fcontent">
                    <input type="hidden" name="id" value="${brand.id }"/>
                    <input type="text" class="required" name="name" value="${brand.name }" maxlength="100"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						上传商品图片(90x150尺寸):</td>
						<td width="80%" class="pn-fcontent">
						注:该尺寸图片必须为90x150。
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">
						<img width="100" height="100" id="allUrl"/>
						<input type="hidden" name="imgUrl" id="imgUrl"/>
                            <input type="file" name="mpf" onchange="uploadPic()"/>
                            123123
                            <script>
                                //上传图片
                                function uploadPic() {
                                    var options = {
                                        url: "/uploadFile.do",
                                        type: "post",
                                        dataType: "json",
                                        success: function (data) {
                                            $("#allUrl").attr("src", data.path)
                                            $("#imgUrl").val(data.path)
                                        }
                                    };
                                    //表单的异步提交(表单提交，页面数据不刷新，可以提交字节流),用于提交图片
                                    $("#jvForm").ajaxSubmit(options);
                                }
                            </script>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						品牌描述:</td><td width="80%" class="pn-fcontent">
                    <input type="text" class="required" name="description" maxlength="80" value="${brand.description }"
                           size="60"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						排序:</td><td width="80%" class="pn-fcontent">
                    <input type="text" class="required" name="sort" value="${brand.sort }" maxlength="80"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否可用:</td><td width="80%" class="pn-fcontent">
						<input type="radio" name="isDisplay" value="1" checked="checked"/>可用
						<input type="radio" name="isDisplay" value="0"/>不可用
					</td>
                    <script>
                        $("input[name='isDisplay']").val(['${brand.isDisplay}'])
                    </script>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
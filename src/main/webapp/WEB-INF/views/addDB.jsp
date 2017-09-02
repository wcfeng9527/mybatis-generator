<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加数据库设置</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<body>
	<div class="container well" style="margin-top:50px;width:550px;">
		<center><h3>添加数据库</h3></center>
		<form id="form1" action="/db/addDBSubmit" method="post" onsubmit="return check()">
			<table class="table">
				
				<tr>
					<td style="text-align:right">showName:</td>
					<td><input type="text" name="showName" id="showName"/></td>
				</tr>		
				<tr>
					<td style="text-align:right">url:</td>
					<td><input type="text" name="url" id="dburl"/></td>
				</tr>		
				<tr>
					<td style="text-align:right">databaseName:</td>
					<td><input type="text" name="databaseName" id="database"/></td>
				</tr>		
				<tr>
					<td style="text-align:right">username:</td>
					<td><input type="text" name="username" id="username"/></td>
				</tr>		
				<tr>
					<td style="text-align:right">pwd:</td>
					<td><input type="text" name="pwd" id="password"/></td>
				</tr>
				<tr>
					<td style="text-align:right">split database and table:
					</td>
					<td>
						<input type="checkbox" value="0" checked="checked" name="state" onClick="chooseOne(this)"/>No
												<input type="checkbox" value="1" name="state" onClick="chooseOne(this)"/>Yes
					</td>
				</tr>
				
				<tr>
					<td colspan="2"><center><input type="submit" class="btn btn-primary" value="提交" /></center></td>
					
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">	
		function chooseOne(cb){   
		    //先取得同name的chekcBox的集合物件   
		    var obj = document.getElementsByName("state");   
		    for (i=0; i<obj.length; i++){   
		        //判斷obj集合中的i元素是否為cb，若否則表示未被點選   
		        if (obj[i]!=cb) obj[i].checked = false;   
		        //若是 但原先未被勾選 則變成勾選；反之 則變為未勾選   
		        //else  obj[i].checked = cb.checked;   
		        //若要至少勾選一個的話，則把上面那行else拿掉，換用下面那行   
		        else obj[i].checked = true;   
		    }   
		}   
		
		
		function check(){
			var showName = $.trim($("#showName").val()); 
			var dburl = $.trim($("#dburl").val()); 
			var database = $.trim($("#database").val()); 
			var username = $.trim($("#username").val()); 
			var password = $.trim($("#password").val()); 
			 if(showName.length == 0) {  
		         alert("showName不能为空！");
		         return false;
		     }  
			 if(dburl.length == 0) {  
		         alert("dburl不能为空！");
		         return false;
		     }  
			 if(database.length == 0) {  
		         alert("database不能为空！");
		         return false;
		     }  
			 if(username.length == 0) {  
		         alert("username不能为空！");
		         return false;
		     }  
			 if(password.length == 0) {  
		         alert("password不能为空！");
		         return false;
		     }  
			return true;
		}
	</script>

</body>
</html>
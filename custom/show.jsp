<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js""></script>
<script type="text/javascript">
		$(function(){
			$("input[type='button']").click(function(){
				var id=$(this).val();
				var pwd=$(this).next().next().val();
				$.ajax({
					dataType:"json",
					type:"post",
					data:{"id":id,"pwd":pwd},
					url:"updateUsers",
					success:function(line){
						alert(line);
						location.href="selectAll";
					}
				})
			})
		})
</script>
</head>
<body>
	<c:forEach items="${userslist}" var="ul">
			<input type="button" value="${ul.id}"  name="id">
			<input type="text" value="${ul.username}" readonly="readonly">
			<input type="text" value="${ul.pwd}"  name="pwd">
			<br/>
	</c:forEach>
</body>
</html>
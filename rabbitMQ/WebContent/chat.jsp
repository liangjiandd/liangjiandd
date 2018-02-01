<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var webSocket = new WebSocket("ws://127.0.0.1:8080/rabbitMQ/ws");
		webSocket.onopen = function(event) {
			alert("连接成功");
		};
		webSocket.onerror = function(event) {
			alert("连接失败");
		};
		webSocket.onclose = function(event) {
			alert("Socket连接断开");
		};
		webSocket.onmessage = function(event) {
			var html=$(".show").html();
			$(".show").html(html+"<br/>"+event.data);
		}
		$("input[type='button']").click(function(){
			var input=$("input[name='input']").val();
			webSocket.send(input);
		});
	})
</script>
</head>
<body>
	<input type="text" name="input">
	<input type="button" value="send">
	<p class="show"></p>

</body>
</html>
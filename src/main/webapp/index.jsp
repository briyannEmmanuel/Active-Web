<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SEND</title>
	</head>
	<body>
		<form method="post" action="send" style="width:60%;" >
		 	<h2 class="title" style="text-transform: uppercase;color: blue;">SEND MESSAGE</h2>
			 	<div class="div mb-3">
					<input type="text" name="queue"  placeholder="Entrer la queue">
				</div>
				<br>
				<div class="div mb-3">
					<input type="text" name="message" placeholder="Entrer le message">
				</div>
				<br>
				<div>
					<input type="submit" class="btn" value="Send">
				</div>
	 	</form>
	</body>
</html>






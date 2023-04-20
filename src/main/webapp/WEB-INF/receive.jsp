<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Receive</title>
	</head>
	<body>
		<form method="post" action="receive" style="width:60%; color: blue;">
	 		<h2 class="title" style="text-transform: uppercase;">SEARCH MESSAGE</h2>
			 	<div class="div">
					<input type="text" name="queue" placeholder="Entrer la queue">
				</div><br>
				<div>
					<input type="submit" class="btn" value="Send">
				</div>
	 	</form>
	</body>
</html>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<p> LOGIN PAGE </p>
		<p><font color="red">${errorMessage}</font></p>
		<form action="/verifyUser" method="post">
			Name : <input name="name" type="text"/>
			Password : <input name="password" type="password" />
			<input type="submit" value="submit" />
		</form>
		
	</body>
</html>
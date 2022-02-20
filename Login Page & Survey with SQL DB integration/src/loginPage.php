<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title>loginPage</title>
</head>
	<body>
		<p><b>Survey Website</b></p>		
		<form action="/login.php" method="POST">
		  <p>
			<label for="user">Username:</label>
			<input id="user" type="text" name="user" />
		  </p>
		  <p>
			<label for="password">Password:</label>
			<input id="pass" type="password" name="pass" />
		  </p>
		  <p>
			<input type="submit" name="login" value="Login" />
		  </p>
		</form>
	</body>
</html>
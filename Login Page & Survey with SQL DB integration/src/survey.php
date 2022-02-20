<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title>survey</title>
</head>
	<body>
		<p><b>Survey Website</b></p>		
		<p><b>Color Survey</b></p>
		<form action="/surveyResult.php" method="POST">
		  <p>
			<label for="name">What is your name?:</label>
			<input id="name" type="text" name="name" />
		  </p>
		  <p>
			<label for="color">What is your favorite color?:</label>
			<input id="color" type="text" name="color" />
		  </p>
		  <p>
			<input type="submit" name="surveyResult" value="Submit" />
		  </p>
		</form>
	</body>
</html>
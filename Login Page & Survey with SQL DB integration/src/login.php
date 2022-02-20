<?php
	$user = $_POST['user'];
	$pass = $_POST['pass'];
	
	$db_link = mysqli_connect("localhost", "root", "");
	if (!$db_link) {
		die(mysqli_error(null));
	}
	$db_users = mysqli_select_db($db_link, "user_data");
		if (!$db_users) {
			die(mysqli_error(null));
		}
	
	$login_request = mysqli_query($db_link, "SELECT * FROM users WHERE username='$user'
	AND password='$pass'");
	
	if(mysqli_num_rows($login_request) == 0) {
		echo "Incorrect login.";
		die(mysqli_error($db_link));
	}
	else{
		//login
		echo "You are now logged in.";
		header("Location: survey.php");
	}
?>


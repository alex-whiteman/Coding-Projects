<?php
	$name = $_POST['name'];
	$color = $_POST['color'];
	echo $name . ", ";
	$db_link = mysqli_connect("localhost", "root", "","user_data");
	if (!$db_link) {
		die(mysqli_error(null));
	}
	$sql = "INSERT IGNORE INTO survey_results(name, result) 
				VALUES('$name', '$color')";
	if(mysqli_query($db_link, $sql)){
		echo "Your response has been recorded.";
	}
	else{
		echo "error";
	}
	mysqli_close($db_link);
?>
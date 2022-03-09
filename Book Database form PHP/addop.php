<?php
        //This program checks for correct user input, if it is correct it adds to the database
        //if the user input is incorrect, display an error message and display the form with those
        //error messages

        //this section validates user input before proceeding
		$bookID = $_POST['bookID'];
		if (empty($bookID))
			$bookID_error = "Book ID is required";
		$title = $_POST['title'];
		if (empty($title))
			$title_error = "Title is required";
		$category = $_POST['category'];
		if (empty($category))
			$category_error = "Category is required";
		$isbn = $_POST['isbn'];
		if (empty($isbn))
			$isbn_error = "ISBN is required";	
		$price = $_POST['price'];
		if (!is_numeric($price))
			$price_error = "Price must be a numeric value";
		if(isset($_POST['author']))
			$author_arr = $_POST['author'];
		else
			$author_error = "Must select at least one author";

        //checks for error messages, if there are none, then proceed with the data entry
        //otherwise, display form again with error messages
		if (!empty($bookID_error) || !empty($title_error) || !empty($category_error) ||
			!empty ($isbn_error) || !empty ($price_error) || !empty ($author_error))
			$inputError = true;
		//===========================================================================
		// this section builds the sql query
        if ($inputError == false) {
			//Books Query:
			$query_books = "INSERT INTO books (ID, Title, Category, ISBN, Price )";
			$query_books .= "VALUES ('$bookID' ,'$title', '$category', '$isbn', $price )";
      
			if (!($result = $pdo->query($query_books))) {
				print( "<p>Could not execute books query!</p>" );
				die("</body></html>" );
			} else {
				echo "<h2>Books table was successfully updated</h2>";
			}	
			foreach ($author_arr as $author) {
				$aid = $authors_ids[$author];
				$query_books_authors = "INSERT INTO books_authors (BID, AID)";
				$query_books_authors .= "VALUES ('$bookID' , '$aid')";
				if (!($result = $pdo->query($query_books_authors))) {
					print( "<p>Could not execute books-authors query!</p>" );
					die("</body></html>");
				} 
			}
			echo "<h2>Books-Authors table was successfully updated with " . 
				 count($author_arr) . " rows</h2>";
			//this section displays all the books authored by the author in the above insert statement
			foreach ($author_arr as $author) {
				$query_author_titles = "SELECT books.Title FROM books, authors, books_authors ";
				$query_author_titles .= "WHERE books.ID = books_authors.BID AND authors.ID = books_authors.AID ";
				$query_author_titles .= "AND authors.Name = '$author'";
				if (!($result = $pdo->query($query_author_titles))) {
					print( "<p>Could not execute select book titles for each author query!</p>" );
					die("</body></html>");
				} 
				else {
					echo "<p><strong>All books authored by " . "$author" . ":</strong></p>";
					while ($row = $result->fetch(PDO::FETCH_NUM)) {
						foreach ( $row as $value ) 
							print( "$value" . "<br>");
					} 
				}
			}
			$displayForm = false;
            //a button used to return to the home page.
            echo '<form action="https://ko-turing.ads.iu.edu/~awhitem/lab4/BooksDBInsertDeleteAllOne.php"><input type="submit" value="Add some more?" /></form>';
		}
?>
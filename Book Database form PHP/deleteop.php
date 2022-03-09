<?php
    //this file is used for deleting data from database. It only needs a BookID in order to
    //delete the book entry and associated entry in the books_authors database.

    //this section simply checks that the bookID field is filled in and actually is in the database
    $bookID = $_POST['bookID'];
    if (empty($bookID))
        $bookID_error = "Book ID is required";

    //this query is used to validate that the bookID exists in the database before continuing
    $verifyQuery = "SELECT id FROM books WHERE id = '$bookID'";
    if (!($result = $pdo->query($verifyQuery))) {
        print ("<p>Could not execute books query.</p>");
        die('<form action="https://ko-turing.ads.iu.edu/~awhitem/lab4/BooksDBInsertDeleteAllOne.php"><input type="submit" value="Try again?" /></form></body></html>');
    }else if (($result->rowCount()==0) && (!empty($bookID))) {
        $bookID_error = "Book ID does not exist.";
        print("<h1><strong>Book does not exist!</strong></h1>");
    }

    //if there are errors, set the inputError flag and redisplay the form with the error
    if (!empty($bookID_error))
        $inputError = true;
    //===========================================================================

    //delete queries
    $deleteBooksAuthorsQuery = "delete from books_authors where bid = '$bookID'";
    $deleteBooksQuery = "delete from books where id = '$bookID'";


    //if all goes well, the data entry associated with the bookID will be deleted.
    if ($inputError == false) {
        if (!($result = $pdo->query($deleteBooksAuthorsQuery))) {
            print("<p>Could not execute delete query from books_authors!</p>");
            die('<form action="https://ko-turing.ads.iu.edu/~awhitem/lab4/BooksDBInsertDeleteAllOne.php"><input type="submit" value="Try again?" /></form></body></html>');
        } else if (!($result = $pdo->query($deleteBooksQuery))) {
            print("<p>Could not execute delete query from books!</p>");
            die("</body></html>");
        } else {
            echo "<h2>Entry successfully deleted.</h2>";
        }
    }
    $displayForm = false;
    //a simple button to return to the home page
    echo '<form action="https://ko-turing.ads.iu.edu/~awhitem/lab4/BooksDBInsertDeleteAllOne.php"><input type="submit" value="Delete some more?" /></form>';
?>
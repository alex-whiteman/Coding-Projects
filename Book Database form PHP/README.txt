This is a web form that is used to both add information to a database
and delete data as well. The database in this project takes use of three
different tables: books, books_authors, and authors. Because books can have
many authors and authors can have many books, the third table is required so
that all authors of a particular book can be efficiently found.

Upon gathering user input, (all fields are required for inserting data, while
only the bookID is required for deleting an entry) the program then uses either
the addop file (to insert data to DB) or the deleteop file (to delete data).

This program takes use of form validation to ensure that all necessary fields
are filled in. If any fields are not filled in, then an error message will
display to the right of that field.

I have included a copy of the database used for this project for your convenience.

Sincerely,
Alex Whiteman

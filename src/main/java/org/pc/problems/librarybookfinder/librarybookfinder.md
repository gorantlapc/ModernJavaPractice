Given a list of Book objects:

record Book(String title, String author, int year, double rating) {}


Create a utility class LibraryUtils with generic methods:

    Find the oldest and newest book

    Filter books by rating > X

    Group books by author

    Return an Optional<Book> when searching by title

Use streams, comparators, and collectors.
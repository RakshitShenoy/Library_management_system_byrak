# Library Management System

A small Java-based library management system for adding books, registering members, issuing and returning books, and searching by title.

## Features

- Add books
- Register members
- Issue books to members
- Return books
- View all books and members
- Search books by title
- Save/load library data from a file

## Project structure

- `project1_java/Book.java` - Book model
- `project1_java/Member.java` - Member model
- `project1_java/Library.java` - Core library logic
- `project1_java/Main.java` - Console app entry point
- `project1_java/filehandel.java` - File save/load handling

## How to run

1. Open a terminal in the project root.
2. Compile the Java files:

```bash
javac .\project1_java\*.java
```

3. Run the program:

```bash
java -cp .\project1_java Main
```

## Notes

- The project is a simple console application.
- The app currently stores data in a simple text file through the file handler.
- The Java class file names are not fully standardized, but the project compiles and runs correctly.

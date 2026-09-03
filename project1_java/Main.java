import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(sc, "Enter choice: ");

            switch (choice) {
                case 1:
                    addBook(sc, library);
                    break;
                case 2:
                    registerMember(sc, library);
                    break;
                case 3:
                    issueBook(sc, library);
                    break;
                case 4:
                    returnBook(sc, library);
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    library.displayAllMembers();
                    break;
                case 7:
                    searchBook(sc, library);
                    break;
                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }

            System.out.println();
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Register Member");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. View All Books");
        System.out.println("6. View All Members");
        System.out.println("7. Search Book by Title");
        System.out.println("8. Exit");
    }

    private static void addBook(Scanner sc, Library library) {
        int id = readInt(sc, "Enter book ID: ");
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        Book book = new Book(id, title, author, isbn);
        library.addBook(book);
    }

    private static void registerMember(Scanner sc, Library library) {
        int id = readInt(sc, "Enter member ID: ");
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        Member member = new Member(id, name);
        library.registerMember(member);
    }

    private static void issueBook(Scanner sc, Library library) {
        int bookId = readInt(sc, "Enter book ID to issue: ");
        int memberId = readInt(sc, "Enter member ID: ");
        library.issueBook(bookId, memberId);
    }

    private static void returnBook(Scanner sc, Library library) {
        int bookId = readInt(sc, "Enter book ID to return: ");
        int memberId = readInt(sc, "Enter member ID: ");
        library.returnBook(bookId, memberId);
    }

    private static void searchBook(Scanner sc, Library library) {
        System.out.print("Enter title keyword: ");
        String keyword = sc.nextLine();

        List<Book> results = library.searchByTitle(keyword);
        if (results.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            for (Book b : results) {
                System.out.println(b);
            }
        }
    }

    private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next(); // discard the invalid token
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}
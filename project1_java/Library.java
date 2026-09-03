import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.gettitle());
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered: " + member.getname());
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getid() == id) {
                return b;
            }
        }
        return null;
    }

    private Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getid() == id) {
                return m;
            }
        }
        return null;
    }

    public void issueBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("No book found with ID " + bookId);
            return;
        }
        if (member == null) {
            System.out.println("No member found with ID " + memberId);
            return;
        }
        if (!book.getisavailable()) {
            System.out.println("\"" + book.gettitle() + "\" is already borrowed.");
            return;
        }

        book.markAsBorrowed();
        member.borrowedbook(book);
        System.out.println("\"" + book.gettitle() + "\" issued to " + member.getname());
    }

    public void returnBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("No book found with ID " + bookId);
            return;
        }
        if (member == null) {
            System.out.println("No member found with ID " + memberId);
            return;
        }
        if (!member.getborrowedbook().contains(book)) {
            System.out.println(member.getname() + " does not have this book borrowed.");
            return;
        }

        book.markAsReturned();
        member.returnBook(book);
        System.out.println("\"" + book.gettitle() + "\" returned by " + member.getname());
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.gettitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library yet.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }
        for (Member m : members) {
            System.out.println(m);
        }
    }
}
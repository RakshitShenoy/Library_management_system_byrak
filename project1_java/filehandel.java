import java.io.*;
import java.util.List;


class LibraryFileHandler {

    private String filePath;

    public LibraryFileHandler(String filePath) {
        this.filePath = filePath;
    }

   
    public void save(List<Book> books, List<Member> members) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            for (Book b : books) {
                writer.println("B," + b.getId() + "," + b.getTitle() + "," +
                                b.getAuthor() + "," + b.getIsbn() + "," + b.isAvailable());
            }

            for (Member m : members) {
                writer.println("M," + m.getId() + "," + m.getName() + "," +
                                borrowedIdsToString(m));
            }

            System.out.println("Library data saved to " + filePath);

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

   
    private String borrowedIdsToString(Member m) {
        StringBuilder sb = new StringBuilder();
        List<Book> borrowed = m.getBorrowedBooks();
        for (int i = 0; i < borrowed.size(); i++) {
            sb.append(borrowed.get(i).getId());
            if (i < borrowed.size() - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }

    public void load(Library library) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No saved data found — starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1); // -1 keeps trailing empty fields

                if (parts[0].equals("B")) {
                    int id = Integer.parseInt(parts[1]);
                    String title = parts[2];
                    String author = parts[3];
                    String isbn = parts[4];
                    Book book = new Book(id, title, author, isbn);
                    library.addBook(book);

                } else if (parts[0].equals("M")) {
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    Member member = new Member(id, name);
                    library.registerMember(member);
                }
            }

           
            reapplyBorrowedBooks(file, library);

            System.out.println("Library data loaded from " + filePath);

        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private void reapplyBorrowedBooks(File file, Library library) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts[0].equals("M") && parts.length > 3 && !parts[3].isEmpty()) {
                    int memberId = Integer.parseInt(parts[1]);
                    String[] bookIds = parts[3].split("\\|");
                    for (String bidStr : bookIds) {
                        int bookId = Integer.parseInt(bidStr);
                        library.issueBook(bookId, memberId);
                    }
                }
            }
        }
    }
}
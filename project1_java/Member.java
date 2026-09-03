import java.util.ArrayList;
import java.util.List;


public class Member 
{
    private int id;
    private String name;
    private List <Book> borrowedbooks;

    public Member(int id,String name)
    {
        this.id=id;
        this.name=name;
        this.borrowedbooks=new ArrayList<>();
    }

    public int getid()
    {
        return id;
    }

    public String getname()
    {
        return name;
    }

    public List<Book> getborrowedbook()
    {
        return borrowedbooks;
    }

    public void setName(String name)
    {
        this.name=name;

    }

    public void borrowedbook(Book book)
    {
        borrowedbooks.add(book);
    }

    public void returnBook(Book book) 
    {
        borrowedbooks.remove(book);
    }

    public int getBorrowedCount() 
    {
        return borrowedbooks.size();
    }

    @Override
    public String toString() 
    {
        return "ID: " + id +
               " | Name: " + name +
               " | Books Borrowed: "+ borrowedbooks.size();
    }
}

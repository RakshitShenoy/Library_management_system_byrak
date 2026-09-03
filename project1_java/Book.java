public class Book 
{
    
    private String title;
    private int id;
    private String author;
    private String book_number;
    private boolean isavailable;

    public Book(int id,String title,String author,String book_number)
    {
        this.id=id;
        this.title=title;
        this.author=author;
        this.book_number=book_number;
        this.isavailable=true;
    }

    public int getid()
    {
        return id;
    }

     public String gettitle()
    {
        return title;
    }

    public String getauthor()
    {
        return author;
    }

    public String getboook_number()
    {
        return book_number;
    }

    public boolean getisavailable()
    {
        return isavailable;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }

    public void setAuthor(String author)
    {
        this.author=author;
    }

    public void setBook_number(String book_number)
    {
        this.book_number=book_number;
    }

    public void setIsavailable(boolean isavailable)
    {
        this.isavailable=isavailable;
    }

    public void markAsBorrowed() 
    {
        this.isavailable = false;
    }
 
    public void markAsReturned() 
    {
        this.isavailable = true;
    }

    @Override
    public String toString() 
    {
        return "ID: " + id +
               " | Title: " + title +
               " | Author: " + author +
               " | Book_number: " + book_number +
               " | Status: " + (isavailable ? "Available" : "Borrowed");
    }
}
       

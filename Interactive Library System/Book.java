
/**
 * Write a description of class Book here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Book
{
    // instance variables - replace the example below with your own
    private String bookname;
    private String authorname;
    private String datepublished; 
    private String uniqueid;

    /**
     * Constructor for objects of class Book
     */
    public Book(String uniqueid, String bookname, String authorname, String datepublished)
    {
        this.uniqueid = uniqueid;
        this.bookname = bookname;
        this.authorname = authorname;
        this.datepublished = datepublished;
    }

    /**
     * 
     */
    public String getuniqueID()
    {
       return uniqueid;
    }
    /**
     * 
     */
    public String getBookename()
    {
       return bookname;
    }
    /**
     * 
     */
    public String getAuthorname()
    {
       return authorname;
    }
    /**
     * 
     */
    public String getDatepublished()
    {
       return datepublished;
    }
}

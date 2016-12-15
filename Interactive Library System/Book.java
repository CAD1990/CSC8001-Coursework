
/**
 * Write a description of class Book here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Book implements Comparable<Book>
{
    private String titleBook;
    private String firstLine;
    private String lastLine;
   
   
    /**
     * Constructor for objects of class Book
     */
    public Book(String titleBook, String firstLine, String lastLine)
    {
        this.titleBook = titleBook;
        this.firstLine = firstLine;
        this.lastLine = lastLine;
    }
   
    /**
     * 
     */
    public String getFirstLine()
    {
        return firstLine;
    }

    /**
     * 
     */
    public String getLastLine()
    {
        return lastLine;
    }
     public String gettitleBook()
    {
        return titleBook;
    }

    @Override
    public int compareTo(Book b)
    {
        int compare = this.lastLine.compareTo(b.getLastLine());
        if (compare <0) 
        {
            return -1;
        }
        else if (compare >0) 
        {
            return 1;
        }
        else
        {
            return compare;
        }
    }
}

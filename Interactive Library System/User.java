
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User implements Comparable<User>
{
    private String firstLine;
    private String lastLine;
    private SortedArrayList<Book> borrowList = new SortedArrayList<Book>();
    /**
     * Constructor for objects of class Book
     */
    public User (String firstLine, String lastLine)
 
    {
        this.firstLine = firstLine;
        this.lastLine = lastLine;
        borrowList = new SortedArrayList<Book>();
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
    public void addBook(Book b)
    {
        borrowList.add(b);
    }
    public void getLoan()
    {
        borrowList.get(0);
    }
    @Override
    public int compareTo(User u)
    {
        int compare = this.lastLine.compareTo(u.getLastLine());
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

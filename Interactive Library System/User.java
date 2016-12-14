
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
    /**
     * Constructor for objects of class Book
     */
    public User (String firstLine, String lastLine)
 
    {
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


/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    private String uniquepersonid;
    private String personfirstname;
    private String personlastname; 
  

    /**
     * Constructor for objects of class Book
     */
    public Person (String uniquepersonid, String personfirstname, String personlastname)
    {
        this.uniquepersonid = uniquepersonid;
        this.personfirstname = personfirstname;
        this.personlastname = personlastname;
        
    }

    /**
     * 
     */
    public String getuniquePersonID()
    {
       return uniquepersonid;
    }
    /**
     * 
     */
    public String getFirstename()
    {
       return personfirstname;
    }
    /**
     * 
     */
    public String getLastname()
    {
       return personlastname;
    }
    public int compareTo(Person p)
    {
        int compare = this.personlastname.compareTo(p.getLastname());
        if (compare < 0) return -1;
        if (compare > 0) return 1;
        return compare;
    }
}

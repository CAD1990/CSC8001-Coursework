import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Write a description of class Library here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Library
{
    // instance variables - replace the example below with your own
    private static SortedArrayList<Book> booking = new SortedArrayList<Book>();
    private static SortedArrayList<User> person = new SortedArrayList<User>();
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<String> string = new ArrayList<String>();
    private static ArrayList<Integer> integer = new ArrayList<Integer>();

    /**
     * Constructor for objects of class Library
     */
    public Library()
    {

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args)throws FileNotFoundException
    {

        ////////////////////////////
        parseFile();
        System.out.println("Size of Integers: " + integer.size());
        System.out.println("Size of Strings: " + string.size());
        System.out.println("Integers");
        System.out.println(integer);
        System.out.println("Strings");
        System.out.println(string);
        System.out.println("Sorted ArrayList Book");
        System.out.println(booking);
        System.out.println("Sorted ArrayList USer");
        System.out.println(person);
        ////////////////////////////    
        System.out.println("############################################");
        System.out.println("############## Library System ##############");
        System.out.println("############################################");
        System.out.println("############################################"); 
        System.out.println("( f )- END PROGRAM");
        System.out.println("( b )- DISPLAY ALL BOOKS");
        System.out.println("( u )- DISPLAY ALL USERS");
        System.out.println("( i )- UPDATE STORED DATA WHEN BOOK ISSUED");
        System.out.println("( r )- UPDATE STORED DATA WHEN BOOK RETURNED");
        System.out.print("> ");
        String choice = input.next().toLowerCase();
        switch (choice) {
            case "f":
            System.exit(0);
            break;
            case "b":
            System.out.println("Number of Books");
            for (int i = 0; i < booking.size(); i++)
            {
                Book b = booking.get(i);
                System.out.println("---------------------------------------");
                System.out.println((i+1) + ") " + b.gettitleBook());
                System.out.println(b.getFirstLine() + " " + b.getLastLine());
                System.out.println("---------------------------------------");
            }
            break;
            case "u":
            System.out.println("Number of Users");
            for (int i = 0; i < person.size(); i++)
            {
                User u = person.get(i);
                System.out.println("---------------------------------------");
                System.out.println(u.getFirstLine() + " " + u.getLastLine());
                System.out.println("---------------------------------------");

            }
            break;
            case "i":
            issueBook();
            break;
            case "r":
            //
            break;
            default:
            // The user input an unexpected choice.
        }
    } 

    public static void parseFile() throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("C:\\Users\\Organise Consulting\\Documents\\GitHub\\CSC8001-Coursework\\Interactive Library System\\input.txt"));
        int num = 0;
        String txt = "";
        while (in.hasNextLine())
        {
            if (in.hasNextInt())
            {
                num = in.nextInt();
                integer.add(num);
            }
            else
            {
                txt = in.nextLine();
                string.add(txt);
            }
        }
        in.close();
        Iterator<String> it = string.iterator();
        while (it.hasNext())
        {
            String remove = it.next();
            if (remove == null || remove.isEmpty())
            {
                it.remove();
            }
        }
        int noBooks = 0;
        int noUsers = 0;
        for (int i = 0; i < integer.size(); i++)
        {
            if (i == 0)
            {
                noBooks = integer.get(i);
            }
            else
            {
                noUsers = integer.get(i);
            }
        }
        String firstLine = "";
        String lastLine = "";

        for (int i = 0; i <string.size(); i++)
        {
            if (i < noBooks * 2)
            {
                if (i % 2 ==0)
                {
                    firstLine = string.get(i+1).substring(0, string.get(i+1).lastIndexOf(" "));
                    lastLine = string.get(i+1).substring(string.get(i+1).lastIndexOf(" ") + 1);
                    booking.add(new Book(firstLine, lastLine, string.get(i)));
                }
            }
            else
            {
                firstLine = string.get(i).substring(0, string.get(i).lastIndexOf(" "));
                lastLine = string.get(i).substring(string.get(i).lastIndexOf(" ") + 1);
                person.add(new User(firstLine, lastLine));
            }
        }
    }

    public static void issueBook()
    {
        System.out.println("Which book would you like to loan?");
        System.out.println();
        for (int i=0; i<booking.size(); i++)
        {
            System.out.println((i+1) +") "+ booking.get(i).gettitleBook()); 
        }
        System.out.println();
        Scanner issuer = new Scanner(System.in);
        System.out.println("Type the name of the book");

        String bookinput = issuer.nextLine();
        System.out.print("> ");
        boolean isExist = false;
        String stored = "";
        String user = "";
        for (int i=0; i<booking.size(); i++)
        {
            Book b = booking.get(i);
            if (bookinput.equalsIgnoreCase(b.gettitleBook()))
            {
                stored = booking.get(i).gettitleBook();
                System.out.println(stored + " is currently in the Library");
                isExist = true;
                break;
            }
        }

        if (isExist)
        {
            System.out.println();
            System.out.println("Please select which user you would like to issue " + stored + " to."); 
            System.out.println();
            for (int i=0; i<person.size(); i++)
            {
                System.out.println((i+1) +") "+ person.get(i).getFirstLine() + " " + person.get(i).getLastLine());
                System.out.println();
            }
            String userinput = issuer.nextLine();
            System.out.print("> ");
            boolean uExist = false;
            int us = 0;
            for (int i=0; i<person.size(); i++)
            {
                User u = person.get(i);
                if (userinput.equalsIgnoreCase(u.getFirstLine() + u.getLastLine()))
                {
                    user = person.get(i).getFirstLine() + u.getLastLine();
                    System.out.println(user + " is currently a valid user.");
                    us = i;
                    uExist = true;
                    break;
                }
            }

            if (uExist)
            {
                String title = "";
                String firstname ="";
                String lastname="";
                int ind = 0;
                for (int i=0; i<booking.size(); i++)
                {
                    Book b = booking.get(i);
                    if (stored.equals(b.gettitleBook()))
                    {
                        ind = i;
                        title = stored;
                        firstname = booking.get(ind).getFirstLine();
                        lastname = booking.get(ind).getLastLine();
                    }
                }
                Book loan = new Book(title, firstname, lastname);
               /////////////Currently Coding///////////////// 
            }
            else
            {
                System.out.println(userinput + " is not currently a valid user.");  
            }

        }
        else
        {
            System.out.println(bookinput + " is not currently in the Library.");
        }

    }
}
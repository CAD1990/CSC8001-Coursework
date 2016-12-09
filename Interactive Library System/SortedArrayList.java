import java.util.ArrayList;
/**
 * Write a description of class SortedArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SortedArrayList <E extends Comparable<E>> extends ArrayList<E>
{
    /**
     * Constructor for objects of class SortedArrayList
     */
    public boolean add(E object)
    {
        //Manual for loop
        for (int index = 0; index < super.size(); index++)
        {
            if (object.compareTo(super.get(index)) ==1)continue;
            super.add(index, object);
            return true;
        }
        return super.add(object);
    }

    
}

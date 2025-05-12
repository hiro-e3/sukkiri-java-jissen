import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1 == null || o2 == null) {
            throw new NullPointerException("the specified object is null");
        }
        return o1.getTitle().compareTo(o2.getTitle());
    }
    
}

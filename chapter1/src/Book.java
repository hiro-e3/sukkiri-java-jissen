import java.util.*;

public class Book implements Comparable<Book>, Cloneable {
    private String title;
    private Date publishedDate;
    private String comment;

    /**
     * Constructor
     * @param title 書籍タイトル
     * @param publishedDate 出版日
     * @param comment コメント
     */
    public Book(String title, Date publishedDate, String comment) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.comment = comment;
    }

    // properties
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;
        return title.equals(book.title) &&
               (book.publishedDate.compareTo(publishedDate) == 0);
    }

    @Override
    public int compareTo(Book o) {
        if(o == null) {
            throw new NullPointerException("the specified object is null");
        }

        return this.publishedDate.compareTo(o.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publishedDate.getTime());
    }

    @Override
    public Book clone() {
        return new Book(this.title, this.publishedDate, this.comment);
    }
};
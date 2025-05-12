import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    static void TestHashSet() {
        var book1 = new Book("Java入門", getDate(2023, 10, 1), "スッキリわかる");
        var book2 = new Book("Python入門", getDate(2023, 10, 2), "カレーも食べたくなる");
        var book3 = new Book("C言語入門", getDate(2023, 10, 3), "ポインタも自由自在");
        var sameAsBook1 = new Book("Java入門", getDate(2023, 10, 1), "スッキリわかる");
        var set = new java.util.HashSet<Book>();
        
        if (!set.add(book1)) {
            throw new AssertionError("HashSetはまだ空なので追加できるはず！");
        }
        
        if (!set.add(book2)) {
            throw new AssertionError("HashSetに出版日とタイトルが同じ本はないので、trueが返るはず！");
        }

        if (!set.add(book3)) {
            throw new AssertionError("HashSetに出版日とタイトルが同じ本はないので、trueが返るはず！");
        }
        
        if (set.add(sameAsBook1)) {
            throw new AssertionError("タイトルと出版日が同じ場合、同じ本として扱われなければいけない！");
        }
    }

    public static void main(String[] args) {
        TestHashSet();
        // new Date(int year, int month, int day) is deprecated
        var book1 = new Book("Java入門", getDate(2023, 10, 1), "スッキリわかる");
        var book2 = new Book("Python入門", getDate(2023, 10, 2), "カレーも食べたくなる");
        var book3 = new Book("C言語入門", getDate(2023, 10, 3), "ポインタも自由自在");
        var books = new ArrayList<Book>(){
            {
                add(book1);
                add(book2);
                add(book3);
            }
        };
        Collections.sort(books, new TitleComparator());
        for (Book b : books) {
            System.out.println(b.getTitle() + " " + b.getPublishedDate());
        }

        var monster1 = new Monster("お化けキノコ", 10, false);
        var monster2 = new Monster("ゴブリン", 25, false);
        var monster3 = new Monster("ドラゴン", 100, true);
        var monsters = new ArrayList<Monster>(){
            {
                add(monster1);
                add(monster2);
                add(monster3);
            }
        };
        for (Monster m : monsters) {
            System.out.println(m.name() + " " + m.hp() + " " + m.isBoss());
        }
    }
    
    public static Date getDate(int year, int month, int day) {
        // Dateのコンストラクタはdeprecatedだが、Calenderだと0msまで厳密に比較されてしまうのでDateを使っていく
        return new Date(year, month, day);
    }
}

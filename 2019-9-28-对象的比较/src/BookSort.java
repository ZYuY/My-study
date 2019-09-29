import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//价格的比较器
class comtitle implements Comparator <BookSort>{

    @Override
    public int compare(BookSort o1, BookSort o2) {
        return o1.title.compareTo(o2.title);
    }
}
//作者的比较器
class coma implements Comparator <BookSort>{

    @Override
    public int compare(BookSort o1, BookSort o2) {
        return o1.author.compareTo(o2.author);
    }
}
//价格的比较器
class comp implements Comparator <BookSort>{
    boolean asc;

    public comp(boolean asc) {
        this.asc = asc;
    }

    @Override
    public int compare(BookSort o1, BookSort o2) {
        if(asc)
            return o1.price-o2.price;
        else
            return o2.price-o1.price;
    }
}
//销量的比较器
class comsa implements Comparator <BookSort>{

    @Override
    public int compare(BookSort o1, BookSort o2) {
        return o1.sales-o2.sales;
    }
}
//评论数量的比较器
class comcomment implements Comparator <BookSort>{

    @Override
    public int compare(BookSort o1, BookSort o2) {
        return o1.comment-o2.comment;
    }
}
//默认ISBN比较
public class BookSort implements Comparable<BookSort>  {
    String isbn;
    String title;
    String author;
    int price;
    int sales;
    int comment;

    public BookSort(String isbn, String title, String author, int price, int sales, int comment) {
        this.isbn = isbn;//ISBN
        this.title = title;//书名
        this.author = author;//作者
        this.price = price;//价格
        this.sales = sales;//销量
        this.comment = comment;//评论数量
    }

    @Override
    public int compareTo(BookSort o) {
        return isbn.compareTo(o.isbn);
    }
public static void insertsort(List<BookSort>booksort) {
    for (int i = 1; i < booksort.size(); i++) {
        BookSort key = booksort.get(i);
        int j = i - 1;
        for (; j >= 0 && booksort.get(j).compareTo(key) > 0; j--) {
            booksort.set(j++,booksort.get(j));
        }
        booksort.set(j+1,key);
    }
}
   public static void insertsort(List<BookSort>booksort,Comparator cmp){
       for(int i=1;i<booksort.size();i++){
           BookSort key=booksort.get(1);
           int j=i-1;
           for(;j>=0&&cmp.compare(booksort.get(j),key)>0;j--){
               booksort.set(j+1,booksort.get(j));
           }
           booksort.set(j+1,key);
       }
   }
    public static void main(String[] args) {
        List<BookSort> list=new ArrayList<>();
        list.add(new BookSort("97872094","从一到无穷大","乔治.加莫夫",1600,400,26));
        list.add(new BookSort("9787020147465", "应物兄", "李洱", 7900, 1668, 300));
        list.add(new BookSort("9787220107085", "如何写甲骨文", "日本文字文化机构", 8800, 23, 6));
        list.add(new BookSort("9787521706635", "敌人与邻居", "[英]伊恩·布莱克", 10800, 3, 0));
        list.add(new BookSort("9787301280751", "法国大革命 (第2版)", "布兰宁(T.C.W.Blanning)", 4500, 1993, 188));

        List<BookSort>copy;
        //按自然顺序排序
        System.out.println("按isbn排序");
        copy=new ArrayList<>(list);
        insertsort(copy);
        System.out.println(copy);
        //按书名排序
        System.out.println("按书名排序");
        copy=new ArrayList<>(list);
        insertsort(copy,new comtitle());
        System.out.println(copy);
        //按价格排序-从小到大
        System.out.println("按 价格-从小到大 排序：");
        copy = new ArrayList<>(list);
        insertsort(copy,new comp(true));
        System.out.println(copy);
        //按价格排序-从大到小
        System.out.println("按 价格-从大到小 排序：");
        copy = new ArrayList<>(list);
        insertsort(copy, new comp(false));
        System.out.println(copy);
    }
}

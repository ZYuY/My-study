import java.util.Comparator;
//复杂比较器
class Personweight implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.hight-o2.hight>0)
            return 1;
        else if(o1.hight-o2.hight<0)
            return -1;

            if(o1.weight-o2.weight>0)
                return 1;
            else if(o1.weight-o2.weight<0)
                return -1;
           int r=o1.name.compareTo(o2.name);
                if(r!=0)
                    return r;
                    return o1.age-o2.age;
            }
        }


//比较器
class PersonHightcompare implements Comparator <Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.hight-o2.hight;
    }
}
class PersonNameCompare implements Comparator <Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Person implements Comparable<Person>{
    String name;
    int age;
    int hight;
    int weight;
    int level;
    int sex;
    public int  compareTo(Person o){
        if(this.age<o.age)
            return -1;
        else if(this.age>o.age)
            return 1;
        else
            return 0;
        //return age-o.age;
    }

    public static void main(String[] args) {
        Person p=new Person();
        p.name="jam";p.age=20;p.hight=180;
        Person q=new Person();
        q.name="tom";q.age=22;q.hight=200;
        int r=p.compareTo(q);
        if(r>0)
            System.out.println("p大");
        else if( r<0)
            System.out.println("q大");
        else
            System.out.println("一样大");
        System.out.println("abc".compareTo("abcd") );

        Comparator<Person>comparator=new PersonNameCompare();
        System.out.println("按照姓名比较");
        int k=comparator.compare(p,q) ;
        if(k>0)
            System.out.println("p大");
        else if( k<0)
            System.out.println("q大");
        else
            System.out.println("一样大");

        Comparator<Person>comhight=new PersonHightcompare();
        System.out.println("按照身高比较");
        int s=comhight.compare(p,q) ;
        if(s>0)
            System.out.println("p高");
        else if( s<0)
            System.out.println("q高");
        else
            System.out.println("一样高");
    }
}


public class Text3 {
    //static boolean a;
    public String neme="abc";
    public static void main(String[] args) {
        //System.out.println(a);
        Text3 a=new Text3();
        Text3 b=new Text3();
        System.out.println(a.equals(b)+" "+a.neme.equals(b.neme));
    }
}

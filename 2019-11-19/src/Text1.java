import java.util.Arrays;

abstract class A{
    abstract void say();
}
public class Text1 {
    public Text1(){
        System.out.println("haha");
    }

    public static void main(String[] args) {
        Text1 a=new Text1();
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        int len=array.length;
        if(len<1){
            return 0;
        }
        int count=0;
        Arrays.sort(array);
        int num=array[len/2];
        for(int i=0;i<len;i++){
            if(num==array[i])
                count++;
        }
        if(count<=(len/2)){
            num=0;
        }
        return num;
    }
}
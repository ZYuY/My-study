import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String str=input.nextLine();
            System.out.println(find(str));
        }

    }
    public static String find(String str){
        ArrayList<String> set=new ArrayList<>();
        str+=" ";
        int count=1;
        int i=0,j=1;
        String top="";
        while(j<str.length()){
            if(str.charAt(i)<'a'||str.charAt(i)>'z'){
                return "0";
            }

            if(str.charAt(i)==str.charAt(j)){
                j++;
                count++;
            }else{
                top+=count;
                top+=str.charAt(i);

                if(!set.contains(top)) {
                    set.add(top);
                }
                i=j;
                j++;
                count=1;
                top=" ";
            }
        }

        String res="";
        for(int p=0;p<set.size();p++){
            //System.out.println(set.get(p));
            res+=set.get(p);
        }
        return res;
    }
}

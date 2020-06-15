import java.util.*;

public class Text {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        System.out.println(find(str));

    }
    public static String find(String str){
    List<String> set=new ArrayList<>();

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
            }else {

                top += count;
                top += str.charAt(i);
//                if (set.size() == 0) {
//                    set.add(top);
//                }
//                if(!set.equals(top)){
//                    set.add(top);


//                } for(int q=0;q<set.size();q++){
//                    if(set.get(q).indexOf(top)==-1){
//                        set.add(top);
//                        break;
//                    }
                i=j;
                j++;
                count=1;
                top=" ";
            }
        }


        String res="";
        for(int p=0;p<set.size();p++){

            res+=set.get(p);
        }
        return res;
    }
}

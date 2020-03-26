import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()) {
            String str = input.nextLine();
            System.out.println(find(str));
        }
    }

    private static String  find(String str) {
        String res="";
        String[]arr=str.split(" ");
        List<Character>list=new ArrayList<>();
        for(int i=0;i<arr[0].length();i++){
            list.add(arr[0].charAt(i));
        }
        for(int i=0;i<arr[1].length();i++){
            if(list.contains(arr[1].charAt(i))){
                list.remove(list.indexOf(arr[1].charAt(i)));
            }else{
                res="No";
                return res;
            }
        }
        res="Yes";
        return res;
    }
}

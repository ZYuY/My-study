import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()) {
            String str1 = input.nextLine();
            String str2 = input.nextLine();
            find(str1, str2);
        }
    }

    private static void find(String str1, String str2) {
        List<Character>list=new ArrayList<>();
        char[]arr1=str1.toCharArray();
        for(int i=0;i<arr1.length;i++){
            list.add(arr1[i]);
        }
        char[]arr2=str2.toCharArray();
        for(int i=0;i<arr2.length;i++){
           for(int j=0;j<list.size();j++){
               if(arr2[i]==list.get(j)){
                   list.remove(j);
                   break;
               }
           }
        }
        if(list.size()==arr1.length-arr2.length){
            System.out.println("Yes"+" "+list.size());
        }else{
            int length=arr2.length-(arr1.length-list.size());
            System.out.println("No"+" "+length);
        }
    }
}

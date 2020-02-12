import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Text {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer>list=new ArrayList<>();
        Arrays.sort(input);
        if(k>input.length||k<0||input.length<=0)
            return list;
        for(int i=0;i<4;i++){
            list.add(input[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            String[] arr = str.split("[a-z,A-Z, ]");
            System.out.println(Arrays.toString(arr));
            String max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].length() > max.length()) {
                    max = arr[i];
                }
            }
            System.out.println(max);
        }
    }
}

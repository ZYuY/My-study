import java.util.Scanner;
import java.util.Stack;

public class Text1 {
    //组个最小数
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int []arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=input.nextInt();
        }
        System.out.print(find(arr));
    }

    private static String find(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(arr[i]!=0&&i!=0){
                stack.push(i);
                arr[i]--;
            }
            if(i==0){
                int k=stack.pop();
                //stack.pop();
                while(arr[i]!=0){
                    stack.push(i);
                    arr[i]--;
                }
                stack.push(k);
            }
        }
        String str=new String();
        while(!stack.isEmpty()){
            str=str+stack.pop();
        }
        return str;
    }
}

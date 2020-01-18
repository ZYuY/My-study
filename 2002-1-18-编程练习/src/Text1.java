import java.util.Arrays;
import java.util.Stack;

public class Text1 {
    //925长按键入
    public boolean isLongPressedName(String name, String typed) {
        if(name.length()>typed.length()){
            return false;
        }
        int i=0;
        int j=0;
        while(i<name.length()&&j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j-1)==typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        /**
         * 特例：pyplrz
         *      ppyypllr
         *      如果name里面的后面字母typed里面没有
         *      所以必须  i==name.length()
         */
        return  i==name.length();
    }

    //977有序数组的平方
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i]*=A[i];
        }
        Arrays.sort(A);
        return A;
    }
    //917仅仅反转字母
    public static  String reverseOnlyLetters(String S) {
        Stack stack=new Stack();
        char[]arr=S.toCharArray();
        for(int i=0;i<S.length();i++){
            if((arr[i]>='A'&&arr[i]<='Z')||(arr[i]>='a'&&arr[i]<='z')){
                stack.push(arr[i]);
                arr[i]=' ';
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==' '){
                arr[i]=(char)stack.pop();
            }
        }
        return String.valueOf(arr);
    }

    //905按奇偶排序数组
    public static  int[] sortArrayByParity(int[] A) {
        int i=0;
        int j=A.length-1;
        while(i<j){
            while(i<j&&A[i]%2==0)
                i++;
            while(i<j&&A[j]%2==1)
                j--;
            int k=A[i];
            A[i]=A[j];
            A[j]=k;
            i++;
            j--;
        }
        return A;
    }

    //724寻找数组的中心索引
    public  static int pivotIndex(int[] nums) {
        if(nums.length==0)
            return -1;
        int sum=0,leftSum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(leftSum*2+nums[i]==sum){
                return i;
            }else{
                leftSum+=nums[i];
            }
        }
        return -1;
//        if(nums==null||nums.length==0)
//            return -1;
//        int i=0;
//        int j=nums.length-1;
//        int sum1=nums[i];
//        int sum2=nums[j];
//        while(i<j){
//            if(nums[i]==0)
//                i++;
//            if(nums[j]==0)
//                j--;
//            if(sum1<sum2){
//                sum1+=nums[++i];
//            }else if(sum1>sum2){
//                sum2+=nums[--j];
//            }else{
//                if((j-i)==2)
//                    return i+1;
//                else
//                    return -1;
//            }
//        }
//        return -1;


    }
    public static void main(String[] args) {
//       String a=reverseOnlyLetters("a-bC-dEf-ghIj");
//        System.out.println(a);
        int[]b={3,1,2,4};
//        sortArrayByParity(b);
//        System.out.println(Arrays.toString(b));
        int[]a={1,7,3,6,5,6};
        System.out.println(pivotIndex(a));
    }
}

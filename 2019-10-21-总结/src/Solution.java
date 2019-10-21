import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        char a='哈';
//        int b=10;
//        System.out.println(a>b);
        int[]a={1,2,3};
        int []b=null;
       b=a;
        Arrays.fill(b,3) ;
        System.out.println(Arrays.toString(b));
        String s1="hello";
        String s2=s1;
        s1="world";
        System.out.println(s2);
    }
    //剑指  旋转数组的最小元素
    /*利用二分法，当两个指针相遇时，则后面那个指针所指的才是最小数值，其次，还要考虑万一是有序数组，直接返回
    * 第一个数，万一数组有特例，例如{1,0,1,1,1}   {1,1,1,0,1}也就是
    * 第一个 中间数字，做后的数字 三个数相同时，只能采用顺序查找法*/
    public int minNumberInRotateArray(int [] array) {
        if(array.length<=0||array==null)
            return 0;
        int i=0;
        int j=array.length-1;
        int index=i;
        while(array[i]>=array[j]){
            if(j-i==1){
                index=j;
                break;
            }
            index=(i+j)/2;
            if(array[i]==array[index]&&array[j]==array[index]){
                return MinInorder(array,i,j);
            }
            if(array[index]>=array[i]){
                i=index;
            }
            if(array[index]<=array[j]) {
                j = index;
            }
        }
        return array[index];
    }

    private int MinInorder(int[] array, int i, int j) {
        int a=array[i];
        for(int f=i+1;f<=j;f++){
            if(array[f]<a){
                a=array[f];
            }
        }
        return a;
    }

}

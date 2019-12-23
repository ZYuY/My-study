import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;

public class Text {
    //求数组最小k个数   需要考虑 k>数组长度  或者  数组长度为0   或者数组为null
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer>array=new ArrayList<>();
        Arrays.sort(input);
        if(k>input.length||input.length==0||input==null) {
            return array;
        }
        for (int i = 0; i < k; i++) {
                array.add(input[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        int[]a={4,5,1,6,2,7,3,8};
        int k=4;
        System.out.println(GetLeastNumbers_Solution(a,k));
    }
}

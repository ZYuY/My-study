import java.util.Arrays;

public class Text1 {
    public static void main(String[] args) {
        //数组转字符串
        int []a={1,2,3,4};
        String str= Arrays.toString(a);
        System.out.println(str);
    }
    //二分查找
    public static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < arr[mid]) {
// 去左侧区间找
                right = mid - 1;
            } else if (toFind > arr[mid]) {
// 去右侧区间找
                left = mid + 1;
            } else {
// 相等, 说明找到了
                return mid;
            }
        }
        return -1;
    }
}

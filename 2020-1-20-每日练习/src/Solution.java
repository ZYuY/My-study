import java.util.Arrays;

public class Solution {
    /**443压缩字符串
     * 输入：
     * ["a","a","b","b","c","c","c"]
     *要考虑数组只有一个字符的情况
     * 还有最后一个字符要特殊处理
     * 输出：
     * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
     */
    public static  int compress(char[] chars) {
        StringBuilder arr=new StringBuilder("");
        if(chars.length==1) {
            arr.append(chars[0]);
            return 1;
        }
        int count=1;
        int i=0;
        for(;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                count ++;
                continue;
            }
            arr.append(chars[i]);
            if(count>1){
            arr.append(count);
            }
            count=1;
        }
        if(chars[i]==chars[i-1]){
            arr.append(chars[i]);
            arr.append(count);
        }else{
            arr.append(chars[i]);
        }
        char[]temp=arr.toString().toCharArray();
        for(int p=0;p<temp.length;p++){
            chars[p]=temp[p];
        }
        return arr.length();
    }

    public static void main(String[] args) {
        char[]app=new char[]{'a','a','b','b','c','c','c'};
        int k=compress(app);
        System.out.println(k);
        System.out.println(Arrays.toString(app));
    }
}

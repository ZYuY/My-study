import java.util.*;

public class Solution2 {
    //删除字符串中的另一个字符串中的所有字符
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String arr1=input.nextLine();
        String arr2=input.nextLine();
        Set<Character> set=new HashSet<>();
        Map<Integer,Character>result=new HashMap<>();
        for(int i=0;i<arr2.length();i++){
            set.add(arr2.charAt(i));
        }
        int k=0;
        for(int j=0;j<arr1.length();j++){
            char a=arr1.charAt(j);
            if(!set.contains(a)){
                result.put(k,a);
                k++;
            }
        }
        char[]app=new char[result.size()];
        for(int i=0;i<result.size();i++){
            app[i]=result.get(i);
        }
        String f=new String(app);//把字符数组转换为字符串
        System.out.println(f.toString());
    }
}

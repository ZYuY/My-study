import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {
    //DNA序列
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        int n=input.nextInt();
        find(str,n);
    }

    private static void find(String str, int n) {
        char[]arr=str.toCharArray();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length-n+1;i++){
            String p="";
            int count=0;
            for(int j=i;j<i+n;j++){
                p=p+arr[j];
                if(arr[j]=='G'||arr[j]=='C'){
                    count++;
                }
            }
            if(!map.containsValue(count)) {
                map.put(p, count);
            }
        }
        int[]q=new int[map.size()];
        int j=0;
        for(String k:map.keySet()){
            q[j++]=map.get(k);
        }
        Arrays.sort(q);
        for(Map.Entry<String,Integer>e:map.entrySet() ){
            if(e.getValue()==q[q.length-1])
            System.out.println(e.getKey());
        }

    }
}

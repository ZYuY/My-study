import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Text2 {
    //成绩排序
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Map<String,String>map=new HashMap<>();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.next();
        }
        String[][]str=new String[n][2];
        for(int i=0;i<n;i++){
            str[i]=arr[i].split(" ");
        }
        for(int i=0;i<n;i++){
            map.put(str[i][0],str[i][1]);
        }
        if(k==0){
            jiangxu(map,n);
        }else{
            shengxu(map,n);
        }
    }

    private static void shengxu(Map<String, String> map,int n) {
        int[]arr=new int[n];
        int i=0;
        for(String e:map.keySet()){
            arr[i]=Integer.valueOf(map.get(e));
            i++;
        }
        Arrays.sort(arr);
        int[]arr2=new int[n];
        for(int p=n-1;p>=0;p--){
            arr2[n-p]=arr[p];
        }
        int j=0;
        for(Map.Entry<String,String>e:map.entrySet()){
            if(Integer.valueOf(e.getValue())==arr2[j]&&j<n){
                System.out.println(e.getKey()+" "+e.getValue());
            }
            j++;
        }
    }

    private static void jiangxu(Map<String, String> map,int n) {
        int[]arr=new int[n];
        int i=0;
        for(String e:map.keySet()){
            arr[i]=Integer.valueOf(map.get(e));
            i++;
        }
        Arrays.sort(arr);
        int j=0;
        for(Map.Entry<String,String>e:map.entrySet()){
            if(Integer.valueOf(e.getValue())==arr[j]&&j<n){
                System.out.println(e.getKey()+" "+e.getValue());
            }
            j++;
        }
    }
}

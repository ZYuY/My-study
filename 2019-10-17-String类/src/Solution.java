import java.util.*;
//811 oj 子域名访问计数
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
     for(String cpdo:cpdomains){
         String[]a=cpdo.split(" ");
         int co=Integer.valueOf(a[0]);
         String domain=a[1];
         String[]b=domain.split("\\.");
         for(int i=0;i<b.length;i++){
             String[]c= Arrays.copyOfRange(b,i,b.length);
            String subdomain1= String.join(".",c);
            int count=map.getOrDefault(subdomain1,0) ;
            map.put(subdomain1,co+count);
         }
     }
     List<String>ret=new ArrayList<>();
     for(Map.Entry<String,Integer>e:map.entrySet()){
         String domain=e.getKey();
         int n=e.getValue();
         String s=String.format("%d,%s",n,domain);
         ret.add(s);
     }
     return ret;
    }

    public static void main(String[] args) {

    }
}

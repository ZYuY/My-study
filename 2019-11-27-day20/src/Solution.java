import java.util.HashMap;
import java.util.Map;

public class Solution {
    //微信红包
    public int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int count=map.getOrDefault(gifts[i],0);
            map.put(gifts[i],count+1);
        }
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            if(e.getValue()>(n/2)){
                return e.getKey();
            }
        }
        return 0;
    }
}

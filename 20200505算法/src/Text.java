import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Text {
    public int numDecodings(String s) {
        final int length = s.length();
        if(length == 0) return 0;
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[length+1];
        dp[0] = 1;

        for(int i=0;i<length;i++){
            dp[i+1] = s.charAt(i)=='0'?0:dp[i];
            if(i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))){
                dp[i+1] += dp[i-1];
            }
        }

        return dp[length];
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key))    map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());

    }

    public int mySqrt(int x) {
        int count=0;
        while(x>1){
            x/=2;
            count++;
        }
        count=count/2;
        return (int)Math.pow(2,count);
    }


}

import java.util.HashSet;
import java.util.Set;

public class Text {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int n=s.length();
        int i=0,j=0,ans=0;
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

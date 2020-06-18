import java.util.*;
public class Solution {
    //无重复字符的最长字串
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)return 0;
        Set<Character>set=new HashSet<>();
        int n=s.length();
        int i=0,j=0,top=0;
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                top=Math.max(top,j-i);
            }else{
                set.remove(s.charAt(i++));
            }

        }
        return top;
    }


}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Text {
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0)
            return true;
        char[] arr = astr.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i]))
                return false;
            else
                list.add(arr[i]);
        }
        return true;
    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1==null||s2==null)return false;
        if(s1.length()!=s2.length())return false;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<s1.length();i++){
            sum1+=s1.charAt(i);
            sum2+=s2.charAt(i);
        }
        return sum1==sum2;
    }

    public String replaceSpaces(String S, int length) {
//        StringBuffer str=new StringBuffer();
//        S=S.trim();
//        for(int i=0;i<S.length();i++){
//            if(S.charAt(i)!=' ')
//                str.append(S.charAt(i));
//            else
//                str.append("%20");
//        }
//        return str.toString();
        return S.substring(0,length).replaceAll(" "," %20");
    }
    public boolean canPermutePalindrome(String s) {
        if(s==null)return false;
        Set<Character> list=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(list.contains(s.charAt(i)))
                list.remove(s.charAt(i));
            else
            list.add(s.charAt(i));
        }
        return list.size()<=1;
    }
    public boolean oneEditAway(String first, String second) {
        if(first==null||second==null)return false;
        if(first==null&&second==null)return true;
        if(first.equals(second))return true;
        if(first.length()-second.length()>1||second.length()-first..length()>1)
        return false;
        return true;
    }
    public boolean oneEditAway1(String first, String second) {
        int len=first.length()-second.length();
        if(len>1||len<-1)return false;
        boolean quick=false;
        char[]arr1=first.toCharArray();
        char[]arr2=second.toCharArray();
        for(int i=0,j=0;i<arr1.length&&j<arr2.length;i++,j++){
            if(arr1[i]==arr2[j])continue;
            if(quick)return false;
            if(len==1)j--;
            if(len==-1)i--;
            quick=true;
        }
        return true;
    }
    public String compressString(String S) {
        String res="";
        int count=0;
        S+="*";
        for(int i=0;i<S.length()-1;i++){
            int j=i+1;
            if(S.charAt(i)==S.charAt(j)){
                count++;
            }
            else{
                res+=S.charAt(i);
                res+=count+1;
                count=0;
            }
        }
        String s=S.substring(0,S.length()-1);
        if(s.length()<=res.length())
            return s;
        else
            return res;
    }
}

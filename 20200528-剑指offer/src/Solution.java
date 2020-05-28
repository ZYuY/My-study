import java.util.ArrayList;

public class Solution {
    //和为s的两个数字
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer>list=new ArrayList<>();
        if(array==null)return list;
        int i=0;
        int j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                break;
            }else if(i<j&&array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
    public String LeftRotateString(String str,int n) {
        if(str==null||str.length()==0)return "";
        n=n%str.length();
        String str1=str.substring(0,n);
        String str2=str.substring(n,str.length());
        return str2+str1;
    }

    public String LeftRotateString2(String str,int n) {
        if(str==null||str.length()==0)return "";
        int len=str.length();
        n=n%str.length();
        str+=str;
        return str.substring(n,len+n);
    }

    public String ReverseSentence(String str) {
        if(str.trim().equals(""))return str;
        String[]arr=str.split(" ");
        String result="";
        for(int i=arr.length-1;i>=0;i--){
            result+=arr[i];
            result+=" ";
        }
        return result.trim();
    }
}

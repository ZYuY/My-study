public class Solution {
    public static void main(String[] args) {
        String str="AaABdBCcCdevQv";
        char[]arr=str.toCharArray();
        int j=-1;
        for(int i=0;i<arr.length-2;i++){
            if((arr[i]==arr[i+2])&&(arr[i]!=arr[i+1])){
                j=i+2;
                i++;
            }else if(i!=j){
                System.out.println(arr[i]);
            }
        }
    }
}

public class Text3 {
    public static void main(String[] args) {
        String a="aaabc";
        char[]arr=a.toCharArray();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1])
                System.out.println(arr[i]);
        }
    }
}

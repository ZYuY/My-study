public class Text {
    /**
     * 第一个只出现一次的字符
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int[]arr=new int[58];
        for(int i=0;i<str.length();i++){
            arr[((int)str.charAt(i))-65]+=1;
        }
        for(int i=0;i<str.length();i++){
            if(arr[((int)str.charAt(i))-65]==1){
                return i;
            }
        }
        return -1;
    }
}

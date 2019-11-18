public class Test2 {
    //生成格雷码

    /**
     * n的格雷码的前半部分时n-1前面补“0”
     * 后半部分从后往前是n-1前面补"1"
     * 递归 利用好String的+的拼接作用
     * @param n
     * @return
     */
    public String[] getGray(int n) {
        String[]arr=null;
        if(n==1) {
            arr = new String[]{"0", "1"};
        }else{
            String[]str=getGray(n-1);
            arr=new String[2*str.length];
            for(int i=0;i<str.length;i++){
                arr[i]="0"+str[i];
                arr[arr.length-1-i]="1"+str[i];
            }
        }
       return arr;
    }
}

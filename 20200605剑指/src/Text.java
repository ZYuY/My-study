public class Text {
    public int Fibonacci(int n) {
        if(n<=0)return 0;
        if(n==1||n==2)return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public boolean Find(int target, int [][] array) {
        if(array==null||array.length==0)return false;
        int i=array[0].length-1;
        int j=0;
        while(i>=0&&j<array.length){
            if(target==array[j][i])return true;
            else if(target>array[j][i]){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        if(str==null)return null;
        StringBuffer result=new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                result.append("%20");
            else
                result.append(str.charAt(i));
        }
        return result.toString();
    }


}

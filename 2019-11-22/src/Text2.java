public class Text2 {
    //生成雷格码
    public String[] getGray(int n){
       if(n==1){
           String[]arr={"0","1"};
           return arr;
       }
       String[]str1=getGray(n-1);
       String[]str2=new String[2*str1.length];
       for(int i=0;i<str1.length;i++){
           str2[i]='0'+str1[i];
           str2[str2.length-1-i]='1'+str1[i];
       }
       return str2;
    }
}

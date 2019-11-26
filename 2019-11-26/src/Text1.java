
public class Text1 {
    //字串判断
    public boolean[] chkSubStr(String[] p, int n, String s) {
      boolean[]result=new boolean[n];
      for(int i=0;i<n;i++){
          if(s.contains(p[i])){
              result[i]=true;
          }else{
              result[i]=false;
          }
      }
      return result;
    }

}

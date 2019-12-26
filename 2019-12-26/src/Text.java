public class Text {
    /**
     * 丑数
     */
    public int GetUglyNumber_Solution(int index) {
        if(index<7)
            return index;
        int[]ret=new int[index];
        ret[0]=1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++){
            ret[i]=min(min(ret[t2]*2,ret[t3]*3),ret[t5]*5);
            if(ret[i]==ret[t2]*2) t2++;
            if(ret[i]==ret[t3]*3)t3++;
            if(ret[i]==ret[t5]*5) t5++;
        }
        return ret[index-1];
    }
    public static int min(int a,int b){
        return a<b?a:b;
    }
}

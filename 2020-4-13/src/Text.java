public class Text {
    public boolean isShu(int a){
        if(a<3){
            return true;
        }
        for(int i=2;i*i<=a;i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    public int work (int n, int[] a) {
        // write code here
        if(a.length<2){
            return 1;
        }
        int count=0;
        for(int i=1;i<a.length;i++){
            int temp=a[i]-a[i-1];
            if(!isShu(temp)){
                if(temp%2==0){
                    count+=1;
                }else{
                    if(isShu(temp-2)){
                        count+=1;
                    }else{
                        count+=2;
                    }
                }
            }
        }
        return n+count;
    }

}

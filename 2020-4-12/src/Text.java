public class Text {
    public long work (int n, long seed1, long seed2, long seed3) {
        long w=0;
        for(long i=1;i<n;i++){
            long seed4=((seed1+seed2)%998244353)*seed3%998244353;
            w+=seed2*seed3%12131415;
            seed3=seed2;
            seed2=seed1;
            seed1=seed4;
        }
        return w;
    }
}

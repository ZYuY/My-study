public class Test1 {
    //无缓存交换
    public int[] exchangeAB(int[] AB) {
        AB[0]=AB[0]^AB[1];
        AB[1]=AB[0]^AB[1];
        AB[0]=AB[0]^AB[1];
        return AB;
    }
}

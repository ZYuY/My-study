public class Erhan {
    private static Erhan test=new Erhan();
    private Erhan(){}

    public static Erhan getInstance(){
        return test;
    }

    public static void main(String[] args) {
        Erhan e=Erhan.getInstance();

    }
}

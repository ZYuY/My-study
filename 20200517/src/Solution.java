public class Solution {

    public static void main(String[] args) {
        ClassLoader load=Solution.class.getClassLoader();
                while(load !=null){
                    load=load.getParent();
                }
    }

}

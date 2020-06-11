public class Text {
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
}

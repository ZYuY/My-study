public class Solution {
    //二维数组中的查找
    public boolean Find(int target, int [][] array) {
        int j = array[0].length-1;
        int i = 0;
        //先判断数组是否为空 是否是二维数组
        if(array!=null&&array[0].length>0&&array.length>0) {
            while (i < array.length && j >= 0) {
                if (array[i][j] == target) {
                    return true;
                } else if (target > array[i][j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return false;
    }
    //替换空格
    public String replaceSpace1(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }
    public String replaceSpace2(StringBuffer str) {
        StringBuilder e=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char a=str.charAt(i);
            if(a==' '){
                e.append("%20") ;
            }else{
                e.append(a);
            }
        }
        return e.toString();
    }

}

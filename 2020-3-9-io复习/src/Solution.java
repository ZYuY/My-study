import java.util.*;

public class Solution {
    /**
    //说反话
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String arr=input.nextLine();
        String[]top=arr.split(" ");
        for(int i=top.length-1;i>0;i--){
            System.out.print(top[i]+" ");
        }
        System.out.println(top[0]);
    }**/

    /**
    //简单错误记录

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Map<String, Integer> map = new LinkedHashMap<String, Integer>();//LinkedHashMap而不是hashmap！！！！！
            String key;
            String filename;
            String path;
            while(in.hasNext()){
                path = in.next();
                //将路径转换为文件名
                int id = path.lastIndexOf('\\');
                //如果找不到说明只有文件名没有路径
                filename = id<0  ? path : path.substring(id+1);
                int linenum = in.nextInt();
                //统计频率
                key = filename+" "+linenum;
                if(map.containsKey(key)){
                    map.put(key, map.get(key)+1);
                }else{
                    map.put(key, 1);
                }
            }

            in.close();

            //对记录进行排序
            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
                //降序
                @Override
                public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                    return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
                }
            });
            //只输出前8条
            int m=0;
            for(Map.Entry<String, Integer> mapping : list){
                m++;
                if(m<=8){
                    String[] str = mapping.getKey().split(" ");
                    String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                    String n = str[1];
                    System.out.println(k+" "+n+" "+mapping.getValue());
                }else{
                    break;
                }

            }

        }**/

    //2的个数
    public int countNumberOf2s(int n) {
        int iCount=0;
        int iFactor=1;
        int iLowerNum=0;
        int iCurrNum=0;
        int iHigherNum=0;
        while(n/iFactor!=0){
            iLowerNum=n-(n/iFactor)*iFactor;
            iCurrNum=(n/iFactor)%10;
            iHigherNum=n/(iFactor*10);

            switch(iCurrNum){
                case 0:
                    iCount+=iHigherNum*iFactor;
                    break;
                case 1:
                    iCount+=iHigherNum*iFactor;
                    break;
                case 2:
                    iCount+=iHigherNum*iFactor+iLowerNum+1;
                    break;
                default:
                    iCount+=(iHigherNum+1)*iFactor;
                    break;
            }
            iFactor*=10;
        }
        return iCount;
    }
//在霍格沃茨找零钱（20）
private static final int[] W = {17*29,29,1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] p = in.next().split("\\.");
        String[] a = in.next().split("\\.");
        int[] P = {Integer.parseInt(p[0]),Integer.parseInt(p[1]),Integer.parseInt(p[2])};
        int[] A = {Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2])};
        int ta = A[0]*W[0]+A[1]*W[1]+A[2]*W[2];
        int tp = P[0]*W[0]+P[1]*W[1]+P[2]*W[2];
        int t = ta-tp;
        if(ta<tp){
            System.out.print("-");
            t = -t;
        }
        System.out.println(t/W[0]+"."+t%W[0]/W[1]+"."+t%W[0]%W[1]/W[2]);
    }
}

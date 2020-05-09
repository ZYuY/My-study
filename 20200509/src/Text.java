public class Text {
    public static void main(String[] args)
    {
        int num = 0;
        //存放一百个灯的亮灭情况，默认为灭，这里取101是为了从编号1到100 方便数字的处理无其他意义
        Boolean[] lights = new Boolean[101];
        //从第1个同学到第100个，依次按灯
        for (int i = 1; i <= 100; i++)
        {
            //从第i个灯开始，隔着i-1个灯按，所以j+=1
            for (int j = i; j <= lights.length - 1; j += i)
            {
                //进行取反操作
                lights[j] = lights[j]?false:true;
            }
        }

        for (int i = 1; i <= lights.length- 1; i++)
        {

            if (lights[i])
            {
                num++;
                //输出亮着的灯编号
                System.out.print(i + "\n");
            }
        }
        System.out.println("亮着的灯总数为：" + num);
    }
}

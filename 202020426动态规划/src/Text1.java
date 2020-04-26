public class Text1 {
    //表态青蛙跳台阶
    public int JumpFloorII(int target) {
        if(target<=0)return 0;
        if(target==1)return 1;
        return JumpFloorII(target-1)*2;
    }
    //矩形覆盖
    public int RectCover(int target) {
        if(target<=0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;

        return RectCover(target-1)+RectCover(target-2);
    }
}

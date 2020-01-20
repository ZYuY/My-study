import java.util.ArrayList;
import java.util.List;

public class Text2 {
    //78子集
    List<List<Integer>> lists = new ArrayList<>();
        public List<List<Integer>> subsets1(int[] nums) {
            if(nums == null || nums.length ==0){
                return lists;
            }
            List<Integer> list = new ArrayList<>();
            process(list, nums, 0);
            return lists;
        }
        private void process(List<Integer>list, int[] nums, int start){
            lists.add(new ArrayList(list));
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                process(list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}

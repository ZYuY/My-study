import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Text {
    //四数之和
    public List<List<Integer>> fourSum(int[] nums, int target){
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target){
        List<List<Integer>>list=new ArrayList<>();
        if(nums==null||nums.length<4)
            return list;
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-3;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;//去重
            int min=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min>target)break;

            int max=nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
            if(max<target)continue;

            for(int j=i+1;j<len-2;j++){
                if(j>i+1&&nums[j]==nums[j-1])continue;

                int k=j+1;
                int h=len-1;

                int min1=nums[i]+nums[j]+nums[k]+nums[k+1];
                if(min1>target)continue;

                int max1=nums[i]+nums[j]+nums[h]+nums[h-1];
                if(max1<target)continue;

                while(k<h){
                    int sum=nums[i]+nums[j]+nums[k]+nums[h];
                    if(sum==target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[h]));
                        k++;

                        while(k<h&&nums[k]==nums[k-1]) {
                            k++;
                        }
                        h--;
                        while(k<h&&j<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(sum<target){
                        k++;
                    }else{
                        h--;
                    }
                }

            }
        }
        return list;
    }

    //三数之和
    public List<List<Integer>> threeSum(int[] nums){
       List< List<Integer>>list=new ArrayList<>();
       if(nums==null||nums.length<3)return list;
        Arrays.sort(nums);
       int len=nums.length;
       for(int i=0;i<len-2;i++){
           if(i>0&&nums[i]==nums[i-1])continue;
           int j=i+1;
           int h=len-1;
           int min=nums[i]+nums[j]+nums[j+1];
           if(min>0)break;
           int max=nums[i]+nums[h]+nums[h-1];
           if(max<0)continue;
           while(j<h){
               int sum=nums[i]+nums[j]+nums[h];
               if(sum==0){
                   list.add(Arrays.asList(nums[i],nums[j],nums[h]));
                   j++;
                   h--;
                   while(j<h&&nums[j]==nums[j-1]){
                       j++;
                   }
                   while(j<h&&i<h&&nums[h]==nums[h+1]){
                       h--;
                   }
               }else if(sum>0){
                   h--;
               }else{
                   j++;
               }
           }
       }
       return list;
    }
}

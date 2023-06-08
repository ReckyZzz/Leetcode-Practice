package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.三数之和
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * */
public class QuadSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target){
        //和三数之和不同，target可以指定为负数，因此剪枝条件需要改变
        //思路还是双指针法，但是需要多加一层循环，最外层为i，里面为j，left和right和三数之和中的相同
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            //剪枝
            if (nums[i] > 0 && nums[i] > target){
                return res;
            }
            //对a(nums[i])去重
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++){
                //对b(nums[j])去重
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    //四数相加，int会溢出
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target){
                        right--;
                    } else if (sum < target){
                        left++;
                    } else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //对c和d去重，收集到元素之后再去重
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}

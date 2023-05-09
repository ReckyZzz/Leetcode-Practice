package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**哈希表部分第5题，15.三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * */
public class TripleSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //关键在于不重复，需要去重，a+b+c=0
        //使用双指针而不使用哈希表,left为index+1，right为数组末尾
        //先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left, right;
        for (int i = 0; i < nums.length; i++){
            //第一个元素大于0，就不可能找到满足条件的三元组
            if (nums[i] > 0)
                return res;
            //对a去重，判断i之前的元素是否出现过，若出现过则为重复元素，不添加
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            left = i + 1;
            right = nums.length - 1;
            //是大于而不是大于等于，若right==left那么最后就变成两个元素了，找不到三个元素了
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //对b和c去重，在找到一个元组之后再进行去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    //去重完成之后移动指针
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}

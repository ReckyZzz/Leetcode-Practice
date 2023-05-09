package HashTable;

import java.util.HashMap;
import java.util.Map;

/**哈希表部分第3题，1.两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target){
        //使用map存放元素及其对应的下标
        //map存放的key为元素，value为下标，因为要判断元素是否出现过
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                //若target-元素存在map中，则找到两个元素
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }else {
                //否则，将其加入map中，map中存的是遍历过的元素
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

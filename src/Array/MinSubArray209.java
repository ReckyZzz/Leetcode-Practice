package Array;

/**
 * 数组部分第4题，209.长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组，并返回其长度，若不存在符合条件的子数组，返回0
 * */
public class MinSubArray209 {
    int minSubArray(int target, int[] nums){
        //滑动窗口方式，使用left和right之间的元素和，left为窗口尾部，right为窗口起始
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int left = 0,right = 0; right < nums.length; right++){
            sum += nums[right];
            //当元素总和大于等于目标值时，移动窗口左端
            //使用while是因为可能会移除多个元素
            while (sum >= target){
                //当前区间res和最小区间进行比较，取最小
                res = Math.min((right - left + 1), res);
                //区间向右移动，left++，同时把最左端元素删除
                sum -= nums[left];
                left++;
            }
        }
        if(res == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return res;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3,1,3};
        int res, target = 7;
        MinSubArray209 minSubArray = new MinSubArray209();
        res = minSubArray.minSubArray(target,arr);
        System.out.println(res);
    }
}

package Array;

import java.util.Arrays;

/**
 * 数组部分第2题，977.有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * */
public class SortedSquare977 {
    int[] sortedSquares(int[] nums){
        //原始暴力解法
        int[] b = new int[nums.length];
        int temp;
        //新数组存储原数组的平方
        for(int i = 0; i < nums.length; i++){
            b[i] = nums[i] * nums[i];
        }
        //冒泡排序
        for(int i = 0; i < b.length - 1; i++){
            for(int j = 0; j < b.length - 1; j++){
                if(b[j] > b[j + 1]){
                    temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
        return b;
    }

    int[] sortedTwoPointers(int[] nums){
        //双指针解法，由于数组是有序的，那么最大值一定出现在数组的两端
        //因此设置left和right两个指针在数组两端，找出最大值放在新数组的最右边
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        //index记录数组最右边的位置
        int index = nums.length - 1;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                //如果左边的元素较大，就记录左边的元素，index记录元素，left向右移动
                res[index] = nums[left] * nums[left];
                index--;
                left++;
            } else{
                //否则就记录右边的元素
                res[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-5,-4,0,3,10};
        int[] res;
        SortedSquare977 sortedSquare = new SortedSquare977();
        //res = sortedSquare.sortedSquares(arr);
        res = sortedSquare.sortedTwoPointers(arr);
        System.out.println(Arrays.toString(res));
    }
}

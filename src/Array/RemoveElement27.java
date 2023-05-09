package Array;

import java.util.Arrays;

/**
 * 数组部分第2题，27.移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * */
public class RemoveElement27 {
    public int remove(int[] nums, int val){
        //暴力实现方法，双层for循环
        //第一个for循环找到指定元素，第二个for循环进行删除，把该元素之后的所有元素向前移一个位置
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(nums[i] == val){
                for(int j = i + 1; j < size; j++){
                    nums[j - 1] = nums[j];
                }
                //找到指定元素之后，所有元素向前移动一位，数组大小减1，i也需要回到前1个位置
                size--;
                i--;
            }
        }
        return size;
    }

    public int removeTwoPointers(int[] nums,int val){
        //双指针实现方式
        //slow代表新数组的下标，fast是指定元素的下标
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                //若fast指向的元素不是指定元素，那么就需要保留
                nums[slow] = nums[fast];
                slow++;
            }
            //若fast指向的元素是指定元素，就不需要保留，slow指针不变
        }
        //慢指针最后为新数组的大小，在新数组后一位
        return slow;
    }

    public static void main(String[] args) {
        RemoveElement27 removeElement = new RemoveElement27();
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        int res;
        //res = removeElement.remove(arr,val);
        res = removeElement.removeTwoPointers(arr,val);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }
}

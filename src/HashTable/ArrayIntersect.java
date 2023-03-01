package HashTable;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersect {
    /**哈希表部分第2题
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
     * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     * */
    int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for(int i : nums1){
            numSet.add(i);
        }
        for(int j : nums2){
            if(numSet.contains(j)){
                result.add(j);
            }
        }
        int[] res = new int[result.size()];
        //方法1 创建新数组
//        int i = 0;
//        for(int j : result){
//            res[i] = j;
//            i++;
//        }

        //方法2
        res = result.stream().mapToInt(x -> x).toArray();
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,23,4,5};
        int[] nums2 = {12,23,4,1};
        ArrayIntersect arrayIntersect = new ArrayIntersect();
        int[] res = arrayIntersect.intersection(nums1, nums2);
        for(int i : res){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

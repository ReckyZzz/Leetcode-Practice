package HashTable;

import java.util.HashMap;
import java.util.Map;

public class QuadSum454 {
    /**哈希表部分第4题 四数相加
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     * */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        //将4个数组分为两组，前两个作为一组，后两个作为一组
        //前两个数组元素之和(a+b)放到map中（因为不仅要记录是否出现过，还要记录出现次数），后两个数组元素之和(c+d)放到map中
        //若两个map元素之和为0，则计数器相应增加map的value。map的key为元素，value为出现次数
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        //遍历前两个数组
        for(int i : nums1){
            for(int j : nums2){
                int temp = i + j;
                if(map.containsKey(temp)){
                    //若temp已经出现过，则次数+1
                    map.put(temp, map.get(temp) + 1);
                }else{
                    //否则，出现次数为1
                    map.put(temp,1);
                }
            }
        }
        //遍历后两个数组
        for(int i : nums3){
            for(int j: nums4){
                //求相反数，看是否出现过
                int reverse = -(i + j);
                if(map.containsKey(reverse)){
                    res += map.get(reverse);
                }
            }
        }
        return res;
    }

}

package stack;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * */
public class TopKFrequent {
    //使用小顶堆实现
    public int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //map统计元素出现频率，key为元素，value为频率
        for (int key : nums) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        //基于小顶堆实现，在优先级队列中存储二元组(num, count)
        //根据频率（数组的第二个元素来排序）
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        //优先级队列接受Comparable接口，表示排序关系，若元素1-元素2则是小堆，元素2-元素1是大堆
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            //若队列的大小大于k，则需要弹出元素
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    //使用大顶堆实现
    public int[] topKBigHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums)
            map.put(item, map.getOrDefault(item,0) + 1);
        //使用大顶堆实现，根据频率（数组的第二个元素来排序）
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组，用逗号隔开：");
        String strArray = scanner.nextLine();
        String[] elements = strArray.split(",");
        int[] array = new int[elements.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }
        System.out.println("请输入k：");
        int k = scanner.nextInt();
        int[] res = topKFrequent.topK(array, k);
        System.out.println("结果为：" + Arrays.toString(res));
    }
}

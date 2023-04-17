package Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * */

//单调队列，队首元素是最大值
class MonoQueue {
    Deque<Integer> deque = new LinkedList<>();

    void poll(int val) {
        //左边要移出的元素是最大值时，才pop元素
        if (!deque.isEmpty() && val == deque.peekFirst()) {
            deque.poll();
        }
    }

    void push(int val) {
        //若加入的元素比队尾的元素大，则把队尾的元素弹出
        //重复此操作直到该元素比队尾元素小
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.pollLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peekFirst();
    }
}

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        //结果数组的长度为输入数组长度 - k + 1
        int resLength = nums.length - k + 1;
        //存放结果
        int[] res = new int [resLength];
        //结果的索引
        int index = 0;
        MonoQueue monoQueue = new MonoQueue();
        //先放k个元素进单调队列中
        for (int i = 0; i < k; i++) {
            monoQueue.push(nums[i]);
        }
        //得到结果的第一个元素
        res[index] = monoQueue.peek();
        index++;
        //i从第k个元素开始，即窗口后的待添加元素
        for (int i = k; i < nums.length; i++) {
            //移除窗口最前面的元素
            monoQueue.poll(nums[i - k]);
            //将窗口后面的元素加入窗口
            monoQueue.push(nums[i]);
            res[index] = monoQueue.peek();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println("请输入数组长度：");
        int length = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[length];
        System.out.println("请输入数组：");
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("请输入k值：");
        int k = Integer.parseInt(scanner.nextLine());
        System.out.println("结果为：" + Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, k)));
    }
}

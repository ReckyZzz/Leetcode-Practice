package greedy;

import java.util.*;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，
 * 前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * */
public class ConstructQ {
    public int[][] reconstructQueue(int[][] people) {
        // 先按身高从大到小排序（若身高相同则按k从小到大排序）
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            int position = person[1]; // 获取k
            // 将数组插入k的位置，因为按身高从大到小排序，所以插入不会影响之前的元素
            list.add(position, person);
        }

        return list.toArray(new int[people.length][]);
    }



    public static void main(String[] args) {
        ConstructQ constructQ = new ConstructQ();
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ints = constructQ.reconstructQueue(people);
        System.out.println(Arrays.deepToString(ints));
    }
}

package HashTable;

public class Anagram242 {
    /**哈希表部分第1题
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * */
    boolean isAnagram(String s, String t) {
        //数组作为哈希表
        int[] hashTable = new int[26];
        for (int i = 0; i < s.length(); i++){
            hashTable[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++){
            hashTable[t.charAt(i) - 'a'] -= 1;
        }
        for (int item : hashTable){
            if (item != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

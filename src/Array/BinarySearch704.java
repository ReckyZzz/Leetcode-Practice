package Array;

public class BinarySearch704 {
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
    //写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
    public int mySearch(int[] nums, int target){
        int left = 0, right = nums.length;//左闭右开
        int mid = (left + right) / 2;
        while(nums[mid] != target && mid > left && mid < right){
            if(target < nums[mid]){//目标小于中间元素，在左边，右边界改变
                right = mid;
            }
            else{//否则就在右边
                left = mid;
            }
            mid = (left + right) / 2;
        }
        if(nums[mid] == target){
            return mid;
        }
        else{
            return -1;
        }
    }

    public int searchRightClosed(int[] nums, int target){//根据左闭右闭的原则来写
        int left = 0, right = nums.length - 1,mid;//左闭右闭
        while(left <= right){
            //left=right是合法区间，需要进行搜索
            mid = (left + right) / 2;
            if(target < nums[mid]){
                //nums[mid]大于target，mid不在搜索区间之内
                right = mid - 1;
            }
            else if(target > nums[mid]){
                //mid位置处严格小于target，不在搜索范围之内
                left = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    public int searchRightOpen(int[] nums, int target){//根据左闭右开的原则来写
        int left = 0, right = nums.length,mid;//左闭右开
        while(left < right){
            //left=right不是合法区间，不进行搜索
            mid = (left + right) / 2;
            if(target < nums[mid]){
                //target小于mid位置元素，mid在搜索区间之内
                right = mid;
            }
            else if(target > nums[mid]){
                //target大于mid位置元素，不在搜索范围之内
                left = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch704 binarySearch = new BinarySearch704();
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        int res;
        //res = binarySearch.mySearch(arr,target);
        //res = binarySearch.searchRightOpen(arr,target);
        res = binarySearch.searchRightClosed(arr,target);
        System.out.println(res);
    }
}

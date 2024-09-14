package ano.easy.easy1_100;

public class searchInsert_35 {

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //请必须使用时间复杂度为 O(log n) 的算法。

    //输入: nums = [1,3,5,6], target = 5
    //输出: 2

    //思路: 除了标准二分, 还有么有更好的实现?
    //一: 递归实现二分查找
    public int searchInsert(int[] nums, int target) {

        //短路
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return target > nums[0] ? 1 : 0;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    //递归二分
    private int binarySearch(int[] nums, int target, int left, int right) {

        //边界条件
        if (left > right) return left;

        //mid指针
        int mid = left + (right - left) / 2;

        //判断移动方向
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {//往小处移动
            return binarySearch(nums, target, left, mid - 1);
        }

        return binarySearch(nums, target, mid + 1, right);
    }
}

package ano.medium.medium1_50;

import java.util.Objects;

public class searchRange_34 {

    //在排序数组中查找元素的 第一个 和 最后一个位置
    //给你一个按照 非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置
    //如果数组中不存在目标值 target，返回 [-1, -1]。
    //你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题

    //输入：nums = [5,7,7,8,8,10], target = 8
    //输出：[3,4]

    //思路:
    //! 一: 正常的前后查找, 注意下标和位置差1, 注意简化开发
    //! 二: 根据用时, 直接前后二分查找

    public int[] searchRange(int[] nums, int target) {

        //短路
        if (Objects.isNull(nums) || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }


        // 一 : 正常前后查找
        //之前思维的点有问题, 太死板的遵照i++的思路把两个指针移动了. 这里修改的i遍历, 当找到了直接存储就很好

/*
        int front = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (front == -1) {
                    front = i;
                }
                end = i;
            }
        }
        return front == -1 ? new int[]{-1, -1} : new int[]{front, end};
*/

        //二 : 正常解法 二分查找

        //二分记得怎么写吗?
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};

    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

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


    }
}

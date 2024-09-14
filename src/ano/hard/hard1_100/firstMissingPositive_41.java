package ano.hard.hard1_100;

import static java.util.Arrays.stream;

public class firstMissingPositive_41 {
    //缺失的第一个正数
    //给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数
    //请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案

    //输入：nums = [1,2,0]
    //输出：3
    //解释：范围 [1,2] 中的数字都在数组中

    //思路
    //! 一: 傻逼的排序 + 指针处理
    //! 二: AI标准解法
    //! 三: API大师

    public int firstMissingPositive(int[] nums) {

        //1. API大师
/*        for (int i = 1; ; i++) {
            int finalI = i;
            if (stream(nums).noneMatch(e -> e == finalI)) {
                return i;
            }
        }*/

        int n = nums.length;

        // 将每个正数放到它应该在的位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 找到第一个位置不正确的正数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有位置都正确，则返回 n + 1
        return n + 1;
    }


}

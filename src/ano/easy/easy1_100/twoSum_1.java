package ano.easy.easy1_100;

import java.util.*;


public class twoSum_1 {

    class Solution {



        /**
         * 两数之和
         */
        public int[] twoSum(int[] nums, int target) {
            /*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
            你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素*/
            //? 输入： nums = [3,2,4], target = 6
            //? 输出：[1,2]

            if (Objects.isNull(nums) || nums.length < 2) {
                return new int[]{0, 0};
            }
            if (nums.length == 2) {
                return new int[]{0, 1};
            }

            //----

            //坑点解析: 只是整数, 可能有负数, 导致最后不一定是逐渐往上加, 并且最大的元素可能比target还要大. 如果忽略这个性能估计会进一步提升
            //但是绝对要从健壮性出发


            //? 暴力for扫描(对照组)
            //double for
            /*for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }*/

            //? 标准双指针
            // 类似排列组合思路
            int first = 0, second = 1;
            while (first < nums.length) {
                while(second < nums.length) {
                    if (nums[first] + nums[second] == target) {
                        return new int[]{first, second};
                    }
                    second += 1;
                }
                first += 1;
                second = first + 1;
            }


            return new int[]{0, 0};



        }

    }


    public static void main(String[] args) {

        Solution solution = new twoSum_1().new Solution();

        int[] nums, res;
        int target;

        nums = new int[]{3, 2, 4};
        target = 6;
        res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
        //? 输出：[1,2]

        nums = new int[]{2, 7, 11, 15};
        target = 13;
        res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
        //? 输出：[0,2]

        nums = new int[]{1, 7, 5, 3, 2, 9, 4};
        target = 16;
        res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
        //? 输出：[1,5]


    }

}

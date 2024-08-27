package ano.easy.easy1_100;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

            //----

            //坑点解析: 只是整数, 可能有负数, 导致最后不一定是逐渐往上加, 并且最大的元素可能比target还要大. 如果忽略这个性能估计会进一步提升
            //但是绝对要从健壮性出发


            //? 个人思路1 : 大小灵活判断(偏贪心)
            //! 由于只需要输出一个可能的解, 并且元素是不能重复使用的
            // 直接取一个, 定死了之后去扫描另一个, 这就是一般想法了. n^2复杂度. for循两层.
            // 优化: 仍然是全扫描, 但是先排序一次, 使用降序排序(系统自带快排). 这样就得到了一个有序的序列了
            // 因为是加法, 并且是越加越多, 直接一口吃最大的一份, 选[0]号元素; 然后判断是不是超过了target.
            // 根据[0]号元素的比较结果进行 聪明 判断:
            // if > target: 用一个指针从最小端往回遍历, 直到找到; 如果小于了就报错(不存在)
            // if < target: 用一个指针指向余下元素的中间位置. 取一位判断
            // 根据结果进行判断, 重复上述步骤


            //* 定义变量

            //快速排序nums: 并要求记录其原先位置和现在的对照关系
            Map<Integer, Integer> map = new HashMap<>();
            int[] num_new= Arrays.copyOf(nums, nums.length);
            Arrays.sort(num_new);

            //创建Map 关联原先位置和现在位置
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], num_new[i]);
            }

            //取最大元素[0]
            int p;

//            if (nums[0] > target) {//判断是否超过target
//                //p从最小端往回遍历, 直到找到; 如果小于了就报错
//                p = nums.length - 1;
//                while (p > 0) {
//                    if (nums[0] + nums[p] == target) {
//                        return new int[]{0, p};
//                    }
//                    p--;
//                }
//            }
//            else{
//                //p指向余下元素的中间位置
//                p = nums.length / 2;
//                while (p > 0 && p < nums.length) {
//                    if (nums[0] + nums[p] > target) {
//                        p++;
//                    } else if (nums[0] + nums[p] < target) {
//                        p--;
//                    } else {
//                        return new int[]{0, p};
//                    }
//                }
//            }

            //fix:
            if (num_new[0] > target) {//判断是否超过target
                //p从最小端往回遍历, 直到找到; 如果小于了就报错
                p = nums.length - 1;
                while (p > 0) {
                    if (num_new[0] + num_new[p] == target) {
                        return new int[]{map.get(num_new[0]), map.get(num_new[p])};
                    }
                    p--;
                }
            }
            else{
                //p指向余下元素的中间位置
                p = nums.length / 2;
                while (p > 0 && p < nums.length) {
                    if (num_new[0] + num_new[p] > target) {
                        p++;
                    } else if (num_new[0] + num_new[p] < target) {
                        p--;
                    } else {
                        return new int[]{map.get(num_new[0]), map.get(num_new[p])};
                    }
                }
            }


            //? 个人思路2 : 暴力for扫描(对照组)


            //? 个人思路3 : 1的修改型(都使用单指针聪明判断)

            //? 个人思路4 : 标准双指针


            return new int[]{0, 0};
        }
    }


    public static void main(String[] args) {
        // 测试
        Solution solution = new twoSum_1().new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

}

package ano.medium.medium1_50;

import java.util.Arrays;

public class threeSumClosest_16 {

    //最接近的三数之和, 和上题类似


    //一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
    //返回这三个数的和
    //假定每组输入只存在恰好一个解

    //思路
    //! 一: 直接和上题一样暴力扫描. 不管了直接暴力做有可以短路的地方: 真的精确找到了target的了之后直接返回这三个数的和即可. -> 失败, 待修改

    public int threeSumClosest(int[] nums, int target) {


        //短路
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }


        Arrays.sort(nums); //升序排序
        int toThrow = 0; //每次固定并抛弃掉一个数(全表)

        int closestSum = Integer.MAX_VALUE;

        while (toThrow < nums.length) {

            //重新深拷贝一波nums到新nums_new, 但是跳过toThrow拷贝
            int[] nums_new = new int[nums.length - 1];
            int p = 0, i = 0;

            while (i < nums.length) {
                if (i == toThrow) {
                    i += 1;
                    continue;
                }
                nums_new[p] = nums[i];
                p += 1;
                i += 1;
            }

            //针对toThrow设置tS, 在缩小的有序Array中双指针大小端查找
            int targetSum = target - nums[toThrow];

            int close = Integer.MAX_VALUE;
            int nowSum = 0, nowClose = Integer.MAX_VALUE;

            int left = 0, right = nums_new.length - 1;

            while (left < right) {

                nowSum = nums_new[left] + nums_new[right];
                nowClose = Math.abs(targetSum - nowSum);
                if (nowClose < close) { //更新closetSum
                    closestSum = nums[toThrow] + nowSum;
                    close = nowClose;
                }

                if (nowSum < targetSum) {
                    left++;
                } else if (nowSum > targetSum) {
                    right--;
                } else {
                    return  nums[toThrow] + nowSum;
                }

            }

            toThrow += 1;
        }
        return closestSum;

    }


    public static void main(String[] args) {
        int[] nums;
        int target;

        //test
        nums = new int[]{-1, 0, 1};
        target = 0;
        System.out.println(new threeSumClosest_16().threeSumClosest(nums, target));
        System.out.println();

        //test
        nums = new int[]{-5, 0, 1, 7};
        target = 4;
        System.out.println(new threeSumClosest_16().threeSumClosest(nums, target));
        System.out.println();

        nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        target = -2;
        System.out.println(new threeSumClosest_16().threeSumClosest(nums, target));
        System.out.println();
    }
}

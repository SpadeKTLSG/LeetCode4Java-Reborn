package ano.medium.medium1_50;

import java.util.*;
import java.util.stream.Collectors;

public class threeSum_15 {

    //一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    //注意：答案中不可以包含重复的三元组

    //?输入：nums = [-1,0,1,2,-1,-4]
    //?输出：[[-1,-1,2],[-1,0,1]]
    //解释：
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0
    //不同的三元组是 [-1,0,1] 和 [-1,-1,2]
    //注意，输出的顺序 和 三元组的顺序 不重要

    //思路
    //看了一下小tip, 确定了是选择用大事化小小事化了的方法来做. 因为没有顺序需求, 可以直接排序减少扫描
    //每次固定一个值, 找另外两个能 与这个相加之后 = 0 的数字(数字本身).
    //! 一: 个人简单模拟
    public List<List<Integer>> threeSum(int[] nums) {


        //短路
        if(nums.length == 3){
            int sum = 0;
            for(int e : nums){
                sum += e;
            }
           return sum == 0 ? new ArrayList<>(Collections.singletonList(Arrays.stream(nums).boxed().collect(Collectors.toList()))) : new ArrayList<>();
        }


        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums); //升序排序
        int toThrow = 0; //每次固定并抛弃掉一个数(全表)

        while (toThrow < nums.length) {

            //重新深拷贝一波nums到新nums_new, 但是跳过toThrow拷贝
            int[] nums_new = new int[nums.length - 1];
            int p = 0, i = 0;

            while (i < nums.length) {
                if (i == toThrow) i += 1;
                if (i == nums.length) break;
                nums_new[p] = nums[i];
                p += 1;
                i += 1;
            }

            //针对toThrow设置tS, 在缩小的有序Array中双指针大小端查找
            int targetSum = -nums[toThrow];
            int left = 0;
            int right = nums_new.length - 1;

            while (left < right) {

                int sum = nums_new[left] + nums_new[right];

                if (sum == targetSum) {
                    //需要判断一下是不是已经有相同元素组成的家伙计入了(原本打算用HM, 现在直接清洗结果集)
                    List<Integer> triplet = Arrays.asList(nums[toThrow], nums_new[left], nums_new[right]);
                    Collections.sort(triplet);
                    res.add(triplet);

                    //跳过临近的重复值
                    while (left < right && nums_new[left] == nums_new[left + 1]) left++;
                    while (left < right && nums_new[right] == nums_new[right - 1]) right--;
                    left++;
                    right--;

                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }

            toThrow += 1;
        }

        //清洗结果集
        Set<String> set = new HashSet<>();
        List<List<Integer>> uniqueRes = new ArrayList<>();
        for (List<Integer> triplet : res) {
            String key = triplet.toString();
            if (!set.contains(key)) {
                set.add(key);
                uniqueRes.add(triplet);
            }
        }
        return uniqueRes;
    }


    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> res;

        //test
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        res = new threeSum_15().threeSum(nums);
        System.out.println(res);
        System.out.println();

        //test
        nums = new int[]{-1, 0, 1};
        res = new threeSum_15().threeSum(nums);
        System.out.println(res);
        System.out.println();

        //test
        nums = new int[]{-1, 0, 4};
        res = new threeSum_15().threeSum(nums);
        System.out.println(res);
        System.out.println();
    }
}

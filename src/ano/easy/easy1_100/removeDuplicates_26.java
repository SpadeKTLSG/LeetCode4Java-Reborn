package ano.easy.easy1_100;

import java.util.Objects;

public class removeDuplicates_26 {


    //删除有序数组中的重复项

    //一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
    // 然后返回 nums 中唯一元素的个数, 多的会抛弃掉

    //思路
    //! 一: 快慢针 : 后面的针用来覆盖 ++, 前面的针直接与缓存比较, 找到了不一样的直接前进找下一个.

    public int removeDuplicates(int[] nums) {

        //短路
        if (Objects.isNull(nums)) return 0;
        if (nums.length == 1) return 1;
        if (nums.length == 2) return nums[0] == nums[1] ? 1 : 2;


        int p = 0, q = 1; //pre- 写指针, q- 读指针
        int store = nums[0];
        while (q < nums.length) {
            if (nums[q] != store) {
                //写指针写入缓存内容
                nums[p] = store;
                store = nums[q];
                p++;
            }
            q++;

        }
        nums[p] = store;
        return p + 1;
    }


}

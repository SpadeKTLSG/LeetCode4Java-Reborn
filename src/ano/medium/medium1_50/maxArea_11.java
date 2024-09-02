package ano.medium.medium1_50;

public class maxArea_11 {

    //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //返回容器可以储存的最大水量


    //思路:
    //! 一双指针 (写烂了, 只会这个)

    public int maxArea(int[] height) {
        //双指针两侧向中央前进
        int max = 0, p = 0, q = height.length - 1;

        while (p!=q) {
            max = Math.max((q - p) * (Math.min(height[p], height[q])), max);

            if (height[p] < height[q]) {
                p++;
            } else {
                q--;
            }
        }
        return max;
    }
}

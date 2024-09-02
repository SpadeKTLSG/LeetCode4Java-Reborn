package ano.hard.hard1_100;

import java.util.Objects;

public class findMedianSortedArrays_4 {

    //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
    //算法的时间复杂度应该为 O(log (m+n))

    //个人思路
    //时间复杂度导致了这题hard? 如果不考虑复杂度直接两个数组合并, 然后返回a[n/2]即可.
    //个人经验还是要考虑一下数学方面的问题. 两个正序数组, 正序说明是升序排列的, 升序意味着:
    //
    //!一: 两个指针指向两个数组最低端, 先记录两个数组的总大小, 如果说两个指针遍历到的数字的数目达到了需要的中位数位置, 那么就返回这个中位数
    //!二: 未想到, 感觉上面已经是最佳解法了


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        //短路
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2[0];
        }
        if (nums2.length == 0 && nums1.length == 1) {
            return nums1[0];
        }
        if (nums2.length == 1 && nums1.length == 1) {
            return (double) (nums1[0] + nums2[0]) / 2;
        }


        //1. 双指针模拟实现 (失败)
       /*
        int p = 0, q = 0; //p->1, q->2
        int nowCount = 0; //当前的计数
        boolean lastPushP = true; //上一个推动了p指针
        int totalLength = nums1.length + nums2.length; // 总长度
        int targetLength; //两个指针分别指向开头

        if (nums1.length == 0 || nums2.length == 0) {
            //有一个是空的, 直接取另一个的中位数
            if (nums1.length == 0) {
                if (nums2.length % 2 == 0) return (double) (nums2[nums2.length / 2] + nums2[nums2.length / 2 + 1]) / 2;
                else return nums2[nums2.length / 2];
            } else {
                if (nums1.length % 2 == 0) return (double) (nums1[nums1.length / 2] + nums1[nums1.length / 2 + 1]) / 2;
                else return nums1[nums1.length / 2];
            }

        }

        if (totalLength % 2 == 0) { //中位数需要相加/2
            targetLength = totalLength / 2;

            while (p < nums1.length && q < nums2.length) {

                //核心: 比较两个指针的大小, 更小的优先获取推动.
                if (nums1[p] <= nums2[q]) {
                    p += 1;
                    lastPushP = true;
                } else if (nums1[p] > nums2[q]) {
                    q += 1;
                    lastPushP = false;
                }

                //更新
                nowCount += 1;

                //结果
                if (nowCount == targetLength) {
                    //还需要一次判断, 直接硬编码解决
                    double temp;
                    if (lastPushP) { //刚记录的是p
                        temp = nums1[p - 1];
                    } else {
                        temp = nums2[q - 1];
                    }

                    //判断双方大小

                    if (p < nums1.length && q < nums2.length) { //越界不能进行判断, 会直接空指针寄了
                        if (nums1[p] <= nums2[q]) { //继续取p
                            return (nums1[p] + temp) / 2;
                        }
                        if (nums1[p] > nums2[q]) {
                            return (nums2[q] + temp) / 2;
                        }
                    } else {//如果取完了其中一个, 直接拿另一个
                        if (p == nums1.length) {
                            //直接取q
                            return (nums2[q] + temp) / 2;

                        } else {
                            return (nums1[p] + temp) / 2;
                        }

                    }
                }

            }
        } else if (totalLength % 2 == 1) {

            //中位数即为Target
            targetLength = totalLength / 2;

            while (p < nums1.length && q < nums2.length) {

                //核心: 比较两个指针的大小, 更小的优先获取推动.
                if (nums1[p] <= nums2[q]) {
                    p += 1;
                    lastPushP = true;
                } else if (nums1[p] > nums2[q]) {
                    q += 1;
                    lastPushP = false;
                }

                //更新
                nowCount += 1;

                //结果
                if (nowCount == targetLength) {

                    return Math.min(nums1[p], nums2[q]);


                }
            }
        }


        return 0;*/

        //2. 无耻的合并解法(肯定超了)

        int[] total = new int[114514];
        int p = 0, q = 0, i = 0;

        //合并(有序) = 比较合并 + 合并剩下的
        while (p < nums1.length && q < nums2.length) {
            total[i++] = nums1[p] <= nums2[q] ? nums1[p++] : nums2[q++];
        }
        while (p < nums1.length) {
            total[i++] = nums1[p++];
        }
        while (q < nums2.length) {
            total[i++] = nums2[q++];
        }

        if (i % 2 == 0) {
            return (double) (total[(i - 1) / 2] + total[(i - 1) / 2 + 1]) / 2;
        }
        return total[(i - 1) / 2];
    }


    public static void main(String[] args) {
        //test
        int[] nums1, nums2;

        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{1, 2, 3};
        System.out.println(new findMedianSortedArrays_4().findMedianSortedArrays(nums1, nums2));
        System.out.println(); //2.0

        nums1 = new int[]{6, 7, 8};
        nums2 = new int[]{9, 10, 22};
        System.out.println(new findMedianSortedArrays_4().findMedianSortedArrays(nums1, nums2));
        System.out.println(); //8.5

        nums1 = new int[]{6, 9, 11};
        nums2 = new int[]{7, 9};
        System.out.println(new findMedianSortedArrays_4().findMedianSortedArrays(nums1, nums2));
        System.out.println(); //9.0

        nums1 = new int[]{6, 7, 8};
        nums2 = new int[]{9, 10};
        System.out.println(new findMedianSortedArrays_4().findMedianSortedArrays(nums1, nums2));
        System.out.println(); //8.0

        nums1 = new int[]{2, 2, 4, 4};
        nums2 = new int[]{2, 2, 2, 4, 4};
        System.out.println(new findMedianSortedArrays_4().findMedianSortedArrays(nums1, nums2));
        System.out.println(); //2.0
    }
}

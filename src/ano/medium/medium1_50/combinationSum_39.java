package ano.medium.medium1_50;

import java.util.*;

public class combinationSum_39 {

    //无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    //
    //candidates 中的 同一个 数字可以 无限制重复被选取
    //如果至少一个数字的被选数量不同，则两种组合是不同的

    //输入：candidates = [2,3,6,7], target = 7
    //输出：[[2,2,3],[7]]
    //解释：
    //2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    //7 也是一个候选， 7 = 7
    //仅有这两种组合

    //思路
    //! 一: 基础的分支限界 (原谅我忘记怎么写了)

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //短路
        if (candidates.length == 1 && candidates[0] == target) {
            List<List<Integer>> temp = new ArrayList<>(new ArrayList<>());
            temp.add(Collections.singletonList(target));
            return temp;
        }
        if (candidates.length == 1 && candidates[0] != target) {
            return new ArrayList<>();
        }

        //一: 基础分支限界
        // 临场时候实在想不起来了就直接用队列来写好了
        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 排序以便于后续剪枝

        //漏了一个start
        backtrack(candidates, target, 0, deque, res);
        return res;
    }


    private void backtrack(int[] candidates, int target, int start, Deque<Integer> deque, List<List<Integer>> res) {

        if (target == 0) { //已经满了, 保存
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target) { // 超过了就剪枝
                break;
            }

            deque.addLast(candidates[i]); //进入

            backtrack(candidates, target - candidates[i], i, deque, res); //深入

            deque.removeLast(); // 退出
        }
    }

}

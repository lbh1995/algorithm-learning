package leetcode;

import java.util.Arrays;

public class LC0473 {
    // 四边的长度
//    int[] sums = new int[4];
//    int[] matchsticks;
//    int length = 0;
//
//    public boolean makesquare(int[] nums) {
//        matchsticks = nums;
//        int sum = 0;
//        for (int stick : matchsticks) {
//            sum += stick;
//        }
//        if (sum % 4 != 0) {
//            return false;
//        }
//        length = sum / 4;
//        Arrays.sort(matchsticks);
//        if (matchsticks[matchsticks.length - 1] > length) {
//            return false;
//        }
//        return dfs(0);
//    }
//
//    private boolean dfs(int startIndex) {
//        if (startIndex == matchsticks.length) {
//            if (sums[0] == length
//                    && sums[1] == length
//                    && sums[2] == length
//                    && sums[3] == length) {
//                return true;
//            }
//            return false;
//        }
//        for (int j = 0; j < 4; j++) {
//            if (sums[j] + matchsticks[startIndex] > length) {
//                continue;
//            }
//            sums[j] += matchsticks[startIndex];
//            if (dfs(startIndex + 1)) {
//                return true;
//            } else {
//                sums[j] -= matchsticks[startIndex];
//            }
//        }
//        return false;
//    }

    public boolean dfsKSubsets(int[] nums, int startIndex, int curSum, int k, int target, boolean []used){
        if(k == 0)return true;
        if(curSum == target) return dfsKSubsets(nums, 0, 0, k - 1, target, used);//找到了一个组合,还有k-1个
        for (int i = startIndex; i < nums.length && curSum + nums[i] <= target; i++) {//剪枝
            if(used[i]) continue;//使用过的元素就不能再使用了
            used[i] = true;//添加元素nums[i]
            if(dfsKSubsets(nums,i+1,curSum+nums[i], k,target,used))
                return true;//如果添加这个元素后，完成了题目要求，就return true.
            used[i] = false;//回溯
            while(i<nums.length - 1&&nums[i+1]==nums[i])//剪枝3 ,非常重要，大幅提升效率
                i++; //如果某个元素无法使得组合达到目标值，那么跟它值相同的元素也不需要添加了
        }
        return false;
    }

    //473. 火柴拼正方形
    //你要用 所有的火柴棍 拼成一个正方形。不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须使用一次
    public boolean makesquare(int[] nums) {
        int sum = 0;
        boolean []used = new boolean[nums.length];
        Arrays.sort(nums);
        for(int n : nums) sum += n;
        if(sum % 4 != 0) return false;
        int target =  sum / 4;//target为每个子集的和
        if(nums[nums.length - 1] > target) return false;
        return dfsKSubsets(nums, 0, 0, 4, target, used);
    }

    public static void main(String[] args) {
        LC0473 lc0473 = new LC0473();
        System.out.println(lc0473.makesquare(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 102}));
    }
}

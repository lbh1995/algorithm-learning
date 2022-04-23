package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liubinghui
 * @date 2021/11/13 5:04 下午
 */
public class LC0001 {
    public int[] twoSum_sort(int[] nums, int target) {
        int[][] numsWithIndex = new int[nums.length][2];
        for (int i = 0;i< nums.length;i++){
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }
        Arrays.sort(numsWithIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]>o2[0]) {
                    return 1;
                }else if (o1[0]<o2[0]) {
                    return -1;
                }
                return 0;
            }
        });
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int[] leftNum = numsWithIndex[left];
            int[] rightNum = numsWithIndex[right];
            if (leftNum[0]+rightNum[0]>target){
                right--;
            }else if (leftNum[0]+rightNum[0]<target){
                left++;
            }else {
                return new int[]{leftNum[1],rightNum[1]};
            }
        }
        return new int[2];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(target-nums[0],0);
        for (int i=1;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        System.out.println(new LC0001().twoSum(nums,6));
    }
}

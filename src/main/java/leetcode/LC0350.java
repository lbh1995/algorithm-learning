package leetcode;

import java.util.*;

public class LC0350 {
    // hashMap
    public static int[] intersectMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        int[] res = new int[nums2.length];
        int total = 0;
        for (int i = 0; i < nums2.length; i++) {
            Integer count = map.getOrDefault(nums2[i], 0);
            if (count != 0) {
                res[total] = nums2[i];
                map.put(nums2[i], count - 1);
                total++;
            }
        }
        return Arrays.copyOfRange(res,0, total);
    }

    // sort
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums2.length];
        int total = 0;
        for (int i = 0,j = 0; i < nums1.length && j<nums2.length ;) {
            if (nums1[i] == nums2[j]) {
                res[total++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res,0, total);
    }


    public static void main(String[] args) {
        System.out.println(intersect(new int[] {1,2,2,1}, new int[]{2,2}));
    }
}

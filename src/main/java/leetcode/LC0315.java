package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0315 {

    public List<Integer> countSmaller(int[] nums) {
        int[] sort = new int[nums.length];
        List<Integer> res = new ArrayList<>(nums.length);
        int[] counts = new int[nums.length];
        int[] countsTemp = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, counts, sort, countsTemp, index, 0, nums.length - 1);
        for (int num : counts) {
            res.add(num);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] counts, int[] numsTemp, int[] indexTemp, int[] index, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, counts, numsTemp, indexTemp, index, mid+1, right);
        mergeSort(nums, counts, numsTemp, indexTemp, index, left, mid);
        int i = left;
        int j = mid + 1;
        int idx = left;
        while (i <= mid && j <= right) {
            if (nums[j] < nums[i]) {
                numsTemp[idx] = nums[i];
                indexTemp[idx] = index[i];
                counts[index[i]] += right - j + 1;
                i++;
                idx++;
            } else {
                numsTemp[idx] = nums[j];
                indexTemp[idx] = index[j];
                j++;
                idx++;
            }
        }
        while (j <= right) {
            numsTemp[idx] = nums[j];
            indexTemp[idx] = index[j];
            idx++;
            j++;
        }
        while (i <= mid) {
            numsTemp[idx] = nums[i];
            indexTemp[idx] = index[i];
            idx++;
            i++;
        }
        for (int k = left; k<= right; k++) {
            nums[k] = numsTemp[k];
            index[k] = indexTemp[k];
        }
    }
}

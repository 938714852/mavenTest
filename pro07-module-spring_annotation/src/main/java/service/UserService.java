package service;

/**
 * @author : wtq
 * @date: 2022/10/27
 */
public class UserService {
    public int search(int[] nums, int target) {
        int mid = nums.length / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            for (int i = 0; i < mid; i++) {
                if (nums[mid] == target) return mid;
            }
        }
        if (nums[mid] < target) {
            for (int i = mid + 1; i < nums.length; i++) {
                if (nums[mid] == target) return mid;
            }
        }
        return -1;
    }
}

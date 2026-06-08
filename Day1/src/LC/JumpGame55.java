package LC;

public class JumpGame55
 {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false; // Can't reach this position
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true; // Can reach the end
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2)); // Output: false
    }
    
}

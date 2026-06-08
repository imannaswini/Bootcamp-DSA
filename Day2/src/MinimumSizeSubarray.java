import java.util.*;

public class MinimumSizeSubarray {

    public static int minSubArrayLen(int target, int[] nums) {

        int minLength = nums.length + 1;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];

            while (currentSum >= target) {

                minLength = Math.min(minLength, right - left + 1);

                currentSum -= nums[left];
                left++;
            }
        }

        return minLength == nums.length + 1 ? 0 : minLength;
    }

    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = minSubArrayLen(target, nums);

        System.out.println("Minimum Length = " + result);
    }
}
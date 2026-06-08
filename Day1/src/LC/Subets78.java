package LC;

import java.util.ArrayList;
import java.util.List;

public class Subets78 
{
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add the current subset to the result

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // Include the current number
            backtrack(nums, i + 1, current, result); // Recur with the next index
            current.remove(current.size() - 1); // Backtrack and remove the last number
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    
}

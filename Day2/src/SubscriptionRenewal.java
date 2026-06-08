/*Subscription Renewal Window (Easy)
Problem Statement:
A subscription service logs renewal dates as an array of integers (day numbers). Find the length of 
the longest contiguous stretch of renewals where the difference between the latest and earliest 
renewal in the stretch is at most K days.
Input: An integer array days (sorted in non-decreasing order) and an integer K.
Output: Length of the longest valid window.
Examples:
• Input: days = [1, 3, 5, 7, 9], K = 4. Output: 3. (Window [1,3,5] has max-min = 4, or [3,5,7], or 
[5,7,9].)
• Input: days = [1, 2, 3, 4, 5], K = 10. Output: 5. (Entire array fits.)
• Input: days = [1, 10, 20, 30], K = 0. Output: 1. (Each element alone.) */
import java.util.*;
public class SubscriptionRenewal 
{
  public static int LongestRenewalWindow(int[] days,int k)
  {
    int maxLength = 0;
    int left = 0;
    
    for (int right = 0; right < days.length; right++) {
      while (days[right] - days[left] > k) {
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of days:");
    int n = sc.nextInt();
    int[] days = new int[n];
    System.out.println("Enter the days of renewal:");
    for (int i = 0; i < n; i++) {
      days[i] = sc.nextInt();
    }
    System.out.println("Enter the value of K:");
    int k = sc.nextInt();
    int result = LongestRenewalWindow(days, k);
    System.out.println("Length of the longest valid window: " + result);

  }
}
/* https://leetcode.com/problems/find-pivot-index */

class PivotIndex {

  public int pivotIndex(final int[] nums) {
    int sum = 0, leftSum = 0;
      
    for (int num : nums) sum += num;
      
    for (int i = 0; i < nums.length; i++) {
        sum -= nums[i];
        if (sum == leftSum) return i;
        leftSum += nums[i];
    }
      
    return -1;
  }
}

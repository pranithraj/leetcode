/* https://leetcode.com/problems/next-permutation */

public class NextPermutation {

  public static void main(String[] args) {
    NextPermutation nextPermutation = new NextPermutation();
    int[] nums = {1, 2, 5, 4, 3};
    nextPermutation.nextPermutation(nums);

    for (int num : nums) System.out.print(num + ", ");
  }

  public void nextPermutation(int[] nums) {
    if (nums.length < 2) return;
    int i = nums.length - 2;

    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    int j = nums.length - 1;

    if (i >= 0) {
      while (nums[i] >= nums[j]) j--;

      swap(i, j, nums);
    }

    reverse(i + 1, nums.length - 1, nums);
  }

  public void swap(int i, int j, int[] nums) {
    int temp;

    temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void reverse(int i, int j, int[] nums) {
    while (i < j) swap(i++, j--, nums);
  }
}

package leetcode;

/* https://leetcode.com/problems/median-of-two-sorted-arrays */

class MedianOfTwoSortedArrays {
 public static void main(String[] args) {
  MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
  int[] arr1 = {2};
  int[] arr2 = {};
  double median = solution.findMedianSortedArrays(arr1, arr2);
 }

 public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
  if (nums1.length > nums2.length) {
   return findMedianSortedArrays(nums2, nums1);
  }
  final int x = nums1.length;
  final int y = nums2.length;

  int start = 0;
  int end = x;

  while (start <= end) {
   int xPartition = (start + end) / 2;
   int yPartition = (x + y + 1) / 2 - xPartition;

   int max_Left_X = (xPartition == 0) ? Integer.MIN_VALUE : nums1[xPartition - 1];
   int min_Right_X = (xPartition == x) ? Integer.MAX_VALUE : nums1[xPartition];

   int max_Left_Y = (yPartition == 0) ? Integer.MIN_VALUE : nums2[yPartition - 1];
   int min_Right_Y = (yPartition == y) ? Integer.MAX_VALUE : nums2[yPartition];

   if (max_Left_X <= min_Right_Y && max_Left_Y <= min_Right_X) {
    if ((x + y) % 2 == 0) {
     return (Math.max(max_Left_X, max_Left_Y) + Math.min(min_Right_X, min_Right_Y)) / 2.0;
    } else {
     return Math.max(max_Left_X, max_Left_Y);
    }
   } else if (max_Left_X > min_Right_Y) {
    end = xPartition - 1;
   } else {
    start = xPartition + 1;
   }
  }
  return 0;
 }
}

/* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array */

class FirstAndLastPositionInSortedArray {
  public int[] searchRange(int[] numbers, int target) {
    int[] range = {-1, -1};

    range[0] = getIndex(numbers, target, true);
    range[1] = getIndex(numbers, target, false);

    return range;
  }

  public int getIndex(int[] numbers, int target, boolean startingIndex) {
    int ans = -1;
    int start = 0, end = numbers.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target < numbers[mid]) {
        end = mid - 1;
      } else if (target > numbers[mid]) {
        start = mid + 1;
      } else {
        ans = mid;
        if (startingIndex) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return ans;
  }
}

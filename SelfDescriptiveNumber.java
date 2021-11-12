public class SelfDescriptiveNumber {

 private static boolean isSelfDescriptive(String s) {
  int[] nums = new int[10];

  for (int i = 0; i < s.length(); i++) {
   int digit = Integer.parseInt(String.valueOf(s.charAt(i)));
   nums[digit]++;
  }

  for (int pos = 0; pos < s.length(); pos++) {
   if (nums[pos] != Integer.parseInt(String.valueOf(s.charAt(pos)))) return false;
  }
  return true;
 }

 public static void main(String[] args) {
  boolean res = isSelfDescriptive("6210001000");
  System.out.println(res);
 }
}

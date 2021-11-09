/* 423. Reconstruct Original Digits from English */
/* https://leetcode.com/problems/reconstruct-original-digits-from-english */

public class JumbledNumbers {
 public static void main(String[] args) {
  String scrambledInput = "zesxrionezoreo";
  String unscrambledOutput = unscramble(scrambledInput);
  System.out.println(unscrambledOutput);
 }

 private static String unscramble(String scrambledInput) {
  int[] arr = new int[10];
  StringBuilder answer = new StringBuilder();

  for (int i = 0; i < scrambledInput.length(); i++) {
   switch (scrambledInput.charAt(i)) {
    case 'z' -> arr[0]++;
    case 'w' -> arr[2]++;
    case 'u' -> arr[4]++;
    case 'x' -> arr[6]++;
    case 'g' -> arr[8]++;

    case 'o' -> arr[1]++;
    case 'r' -> arr[3]++;
    case 'v' -> arr[5]++;
    case 's' -> arr[7]++;
    case 'i' -> arr[9]++;
   }
  }

  arr[1] -= (arr[0] + arr[2] + arr[4]);
  arr[3] -= (arr[4] + arr[0]);
  arr[9] -= (arr[6] + arr[5] + arr[8]);
  arr[5] -= arr[7];
  arr[7] -= arr[6];

  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < arr[i]; j++) {
    answer.append(i);
   }
  }
  return answer.toString();
 }
}

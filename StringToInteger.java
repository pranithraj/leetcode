/* https://leetcode.com/problems/string-to-integer-atoi */

public class StringToInteger {
  public static void main(String[] args) {
    StringToInteger sToI = new StringToInteger();
    String input = "9223372036854775808";
    System.out.println(sToI.myAtoi(input));
  }

  public int myAtoi(String s) {
    int stringLength = s.length();
    long longNum = 0;
    int currentPosition = 0;
    boolean positive = true;

    if (s.isEmpty()) return 0;

    while (currentPosition < stringLength && s.charAt(currentPosition) == ' ') {
      currentPosition++;
    }

    if (currentPosition < stringLength && s.charAt(currentPosition) == '-') {
      currentPosition++;
      positive = false;
    } else if (currentPosition < stringLength && s.charAt(currentPosition) == '+') {
      currentPosition++;
    }

    while (currentPosition < stringLength
            && s.charAt(currentPosition) >= '0'
            && s.charAt(currentPosition) <= '9') {
      // append each digit that's read
      longNum = longNum * 10 + s.charAt(currentPosition) - '0';
      if (longNum >= Integer.MAX_VALUE && positive) {
        longNum = Integer.MAX_VALUE;
        break;
      } else if (longNum > Integer.MAX_VALUE && !positive) {
        longNum = Integer.MIN_VALUE;
        break;
      }
      currentPosition++;
    }
    if (!positive) {
      longNum = longNum * (-1);
    }
    return (int) longNum;
  }
}

/* https://leetcode.com/problems/happy-number */

class HappyNumber {
    public boolean isHappy(int n) {
        final Set<Integer> set = new HashSet<>();

        while (set.add(n)) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow((n % 10), 2);
                n = n / 10;
            }
            if (sum == 1) return true;
            else n = sum; 
        }
        return false;
    }
}
